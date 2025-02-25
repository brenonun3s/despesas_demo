package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "transacoes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transacoes implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "tipo_transacao", nullable = false, length = 50)
    private String tipoTransacao;

    @Column(name = "nome_transacao", nullable = false, length = 50)
    private String nomeTransacao;


    @Column(name = "valor", nullable = false)
    private Float valor;

    @Column(name = "data_movimentacao", nullable = false, length = 50)
    private LocalDate dataMovimentacao;

    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;

    



}
