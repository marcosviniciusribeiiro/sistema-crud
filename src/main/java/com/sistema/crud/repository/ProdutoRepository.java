package com.sistema.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sistema.crud.model.Produto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> { }
