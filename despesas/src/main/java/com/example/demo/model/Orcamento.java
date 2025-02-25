package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "orcamentos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orcamento implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "orcamento_total")
    private Float orcamentoTotal;

    @Column(name = "valor_gasto")
    private Float valorGanhoTotal;

    @Column(name = "valor_restante")
    private Float valorRestante;



}

