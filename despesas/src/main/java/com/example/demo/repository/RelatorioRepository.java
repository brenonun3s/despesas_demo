package com.example.demo.repository;

import com.example.demo.model.Relatorios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RelatorioRepository extends JpaRepository<Relatorios, UUID> {

}
