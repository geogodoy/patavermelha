package com.patavermelha.patavermelha.controller;

import com.patavermelha.patavermelha.entities.Clinica;
import com.patavermelha.patavermelha.entities.Ocorrencia;
import com.patavermelha.patavermelha.service.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("clinicas")
public class ClinicaController {

    @Autowired
    private ClinicaService clinicaService;

    @GetMapping(value = "/{idClinica}")
    @ResponseBody
    public Clinica searchClinicaById(@PathVariable("idClinica")UUID idClinica) throws Exception {
        return clinicaService.searchClinicaById(idClinica);
    }

    @GetMapping
    @ResponseBody
    public List<Clinica> searchAllClinicas() {
        return clinicaService.searchAllClinicas();
    }

    @PostMapping
    @ResponseBody
    public Clinica saveClinica(@RequestBody Clinica clinica){
        return clinicaService.saveClinica(clinica);
    }

    @PostMapping(value = "/{idClinica}/associa-ocorrencia/{idOcorrencia}")
    @ResponseBody
    public Clinica associateOcorrenciaClinica(@PathVariable("idClinica") UUID idClinica,
                                              @PathVariable("idOcorrencia") UUID idOcorrencia) throws Exception {
        return clinicaService.associateOcorrenciaClinica(idClinica, idOcorrencia);
    }

    @PutMapping
    @ResponseBody
    public Clinica updateClinica(@RequestBody Clinica clinica) throws Exception {
     return clinicaService.updateClinica(clinica);
    }

    @DeleteMapping
    public void deleteClinica(@PathVariable("idClinica") UUID idClinica) throws Exception {
        clinicaService.deleteClinica(idClinica);
    }

}
