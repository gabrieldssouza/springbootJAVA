package com.cimol.crudapp.repository;

import com.cimol.crudapp.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    }


