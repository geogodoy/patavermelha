package com.patavermelha.patavermelha.controller;

import com.patavermelha.patavermelha.entities.Ocorrencia;
import com.patavermelha.patavermelha.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("ocorrencias")
public class OcorrenciaController {
    @Autowired
    private OcorrenciaService ocorrenciaService;

    @GetMapping(value = "/{idOcorrencia}")
    @ResponseBody
    public Ocorrencia searchOcorrenciaById(@PathVariable("idOcorrencia") UUID idOcorrencia) throws Exception {
        return ocorrenciaService.searchOcorrenciaById(idOcorrencia);
    }

    @GetMapping
    @ResponseBody
    public List<Ocorrencia> searchAllOcorrencias() {
        return ocorrenciaService.searchAllOcorrencias();
    }

    @PostMapping
    @ResponseBody
    public Ocorrencia saveOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaService.saveOcorrencia(ocorrencia);
    }

    @PutMapping
    @ResponseBody
    public Ocorrencia updateOcorrencia(@RequestBody Ocorrencia ocorrencia) throws Exception {
        return ocorrenciaService.updateOcorrencia(ocorrencia);
    }

    @DeleteMapping(value = "/{idOcorrencia}")
    public void deleteOcorrencia(@PathVariable("idOcorrencia") UUID idOcorrencia) throws Exception {
        ocorrenciaService.deleteOcorrencia(idOcorrencia);
    }
}
