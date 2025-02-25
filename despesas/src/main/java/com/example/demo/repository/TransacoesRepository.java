package com.example.demo.repository;

import com.example.demo.model.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransacoesRepository extends JpaRepository<Transacoes, UUID> {


    List<Transacoes> findByValorAndTipoTransacao(Float valor, String tipoTransacao);
}
