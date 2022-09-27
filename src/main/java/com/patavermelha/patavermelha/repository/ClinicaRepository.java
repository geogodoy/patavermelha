package com.patavermelha.patavermelha.repository;

import com.patavermelha.patavermelha.entities.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClinicaRepository extends JpaRepository<Clinica, UUID> {
}
