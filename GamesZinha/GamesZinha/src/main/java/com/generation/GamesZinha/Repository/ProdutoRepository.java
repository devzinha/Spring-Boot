package com.generation.GamesZinha.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.GamesZinha.Model.Produto;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Long> {

}
