package com.cimol.crudapp.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime data;

    private Double total;

    @ManyToOne
    private Cliente cliente;

    @ManyToMany
    private List<Produto> produtos;
}

