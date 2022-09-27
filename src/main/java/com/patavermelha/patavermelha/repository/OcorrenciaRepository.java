package com.patavermelha.patavermelha.repository;

import com.patavermelha.patavermelha.entities.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, UUID> {


}
