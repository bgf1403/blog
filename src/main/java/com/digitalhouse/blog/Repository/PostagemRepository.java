package com.digitalhouse.blog.Repository;

import com.digitalhouse.blog.Model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


    @Repository
    public interface PostagemRepository extends JpaRepository<Postagem, Long>{

        public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);

        public List<Postagem> findAllByTextoContainingIgnoreCase(String texto);
    }

