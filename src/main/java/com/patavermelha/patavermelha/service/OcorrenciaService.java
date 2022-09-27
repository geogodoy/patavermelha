package com.patavermelha.patavermelha.service;

import com.patavermelha.patavermelha.entities.Ocorrencia;
import com.patavermelha.patavermelha.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OcorrenciaService {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    public Ocorrencia searchOcorrenciaById(UUID idOcorrencia) throws Exception {
        if (idOcorrencia != null) {
            boolean existsById = ocorrenciaRepository.existsById(idOcorrencia);

            if (existsById) {
                return ocorrenciaRepository.findById(idOcorrencia).get();
            }
        }

        throw new Exception("Ocorrência não encontrada");
    }

    public List<Ocorrencia> searchAllOcorrencias() {
        return ocorrenciaRepository.findAll();
    }

    public Ocorrencia saveOcorrencia(Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    }

    public Ocorrencia updateOcorrencia(Ocorrencia ocorrencia) throws Exception {
        if (ocorrencia.getIdOcorrencia() != null) {
            boolean existsById = ocorrenciaRepository.existsById(ocorrencia.getIdOcorrencia());

            if (existsById) {
                return ocorrenciaRepository.save(ocorrencia);
            }
        }

        throw new Exception("Ocorrência não encontrada");
    }

    public void deleteOcorrencia(UUID idOcorrencia) throws Exception {
        if (idOcorrencia != null) {
            boolean existsById = ocorrenciaRepository.existsById(idOcorrencia);

            if (existsById) {
                Ocorrencia ocorrencia = ocorrenciaRepository.findById(idOcorrencia).get();
                ocorrenciaRepository.delete(ocorrencia);
                return;
            }
        }

        throw new Exception("Ocorrência não encontrada");

    }
}
