package com.digitalhouse.blog.Controller;

import com.digitalhouse.blog.Model.Postagem;
import com.digitalhouse.blog.Repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostController {

    @Autowired
    private PostagemRepository repository;

    @GetMapping
    public ResponseEntity<List<Postagem>> GetAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postagem> GetById(@PathVariable Long id) {

        return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity <List<Postagem>> GetByTitulo(@PathVariable String titulo){
        return  ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
    }

    @GetMapping("/texto/{texto}")
    public ResponseEntity <List<Postagem>> GetByTexto(@PathVariable String texto){
        return  ResponseEntity.ok(repository.findAllByTextoContainingIgnoreCase(texto));
    }

    @PostMapping
    public ResponseEntity<Postagem> post(@RequestBody Postagem postagem){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
    }
}



