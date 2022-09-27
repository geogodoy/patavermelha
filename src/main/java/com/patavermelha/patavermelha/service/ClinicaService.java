package com.patavermelha.patavermelha.service;

import com.patavermelha.patavermelha.entities.Clinica;
import com.patavermelha.patavermelha.entities.Ocorrencia;
import com.patavermelha.patavermelha.repository.ClinicaRepository;
import com.patavermelha.patavermelha.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClinicaService {

    @Autowired
    private ClinicaRepository clinicaRepository;
    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    public Clinica searchClinicaById(UUID idClinica) throws Exception {
        if (idClinica != null) {
            boolean existsById = clinicaRepository.existsById(idClinica);

            if (existsById) {
                return clinicaRepository.findById(idClinica).get();
            }
        }

        throw new Exception("Clínica não encontrada");
    }

    public List<Clinica> searchAllClinicas() {
        return clinicaRepository.findAll();
    }

    public Clinica saveClinica(Clinica clinica) {
        return clinicaRepository.save(clinica);
    }

    public Clinica updateClinica(Clinica clinica) throws Exception {
        if (clinica.getId() != null) {
            boolean existsById = clinicaRepository.existsById(clinica.getId());

            if (existsById) {
                return clinicaRepository.save(clinica);
            }
        }

        throw new Exception("Clínica não encontrada");
    }

    public void deleteClinica(UUID idClinica) throws Exception {
        if (idClinica != null) {
            boolean existsById = clinicaRepository.existsById(idClinica);

            if (existsById) {
                Clinica clinica = clinicaRepository.findById(idClinica).get();
                clinicaRepository.delete(clinica);
                return;
            }
        }

        throw new Exception("Clínica não encontrada");
    }

    public Clinica associateOcorrenciaClinica(UUID idClinica, UUID idOcorrencia) throws Exception {
        if (idOcorrencia != null && idClinica != null) {
            boolean existsOcorrencia = ocorrenciaRepository.existsById(idOcorrencia);
            boolean existsClinica = clinicaRepository.existsById(idClinica);

            if (existsClinica && existsOcorrencia) {
                Clinica clinica = clinicaRepository.findById(idClinica).get();
                Ocorrencia ocorrencia = ocorrenciaRepository.findById(idOcorrencia).get();
                clinica.getOcorrencias().add(ocorrencia);

                return clinicaRepository.save(clinica);
            }
        }
        throw new Exception("Ocorrência ou clinica não encontradas");
    }
}
