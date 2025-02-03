package br.com.gerenciadordespesas.despesas.model;

import br.com.gerenciadordespesas.despesas.model.enums.TypeOfTransaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaco", nullable = false)
    private Long id;

    @Column(name = "nome_transacao", nullable = false)
    private String nameTransaction;

    @Column(name = "descricao", nullable = false)
    private String description;

    @Column(name = "valor", nullable = false)
    private Double value;

    @Column(name = "tipo_transacao", nullable = false)
    private TypeOfTransaction tipo;




}
