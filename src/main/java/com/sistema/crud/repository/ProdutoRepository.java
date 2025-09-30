package com.sistema.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sistema.crud.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> { }
