package com.digitalhouse.blog.Repository;

import com.digitalhouse.blog.Model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {

    public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);

}
