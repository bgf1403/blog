package com.digitalhouse.blog.Controller;

import com.digitalhouse.blog.Model.Tema;
import com.digitalhouse.blog.Repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/temas")
@CrossOrigin(value = "", allowedHeaders = "*")
public class TemaController {

    @Autowired
    private TemaRepository temaRepository;


    @GetMapping
    public ResponseEntity<List<Tema>> getAll(){
        return ResponseEntity.ok(temaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tema> getById(@PathVariable Long id){
        return temaRepository.findById(id).map(resp -> ResponseEntity.ok(resp))  //option java - expressão lambda
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping ("/descricao/{descricao}")
    public ResponseEntity <List<Tema>> getByDescricao(@PathVariable String descricao){
        return ResponseEntity.ok(temaRepository.findAllByDescricaoContainingIgnoreCase(descricao));
    }


    @PostMapping
    public ResponseEntity<Tema> post (@RequestBody Tema tema){
        return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
    }

    @PutMapping
    public ResponseEntity<Tema> put (@RequestBody Tema tema){
        return ResponseEntity.ok(temaRepository.save(tema));
    }

}