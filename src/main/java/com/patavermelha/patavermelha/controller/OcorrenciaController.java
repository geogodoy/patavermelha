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

//    //Primeiro cenario
//    @GetMapping(value = "/testeCorpo")
//    @ResponseBody
//    public Resposta retornaTextoDoCorpo(@RequestParam String texto) {
//        Resposta resposta = new Resposta();
//        resposta.setMensagem(texto);
//        return resposta;
//    }
//
//    //Segundo cenario
//    @GetMapping(value = "/testeUrl/{id}")
//    @ResponseBody
//    public Resposta retornaTextoDaUrl(@PathVariable("id") String texto) {
//        Resposta resposta = new Resposta();
//        resposta.setMensagem("ID: " + texto);
//        return resposta;
//    }
//
//    //Terceiro cenario
//    @PostMapping(value = "/testeSomaComDoisNumerosBody")
//    @ResponseBody
//    public Resposta retornaSomaDeDoisNumerosBody(
//            @RequestParam Integer numero1, @RequestParam Integer numero2) {
//        Resposta resposta = new Resposta();
//        resposta.setMensagem(String.valueOf(numero1 + numero2));
//        return resposta;
//    }
//
//    //Quarto cenario
//    @PostMapping(value = "/testeSomaComDoisNumerosJson")
//    @ResponseBody
//    public Resposta retornaSomaDeDoisNumerosJson(@RequestBody NumeroDto numeroDto) {
//        Resposta resposta = new Resposta();
//        resposta.setMensagem(String.valueOf(numeroDto.getNumero1() + numeroDto.getNumero2()));
//        return resposta;
//    }
//
//    //Quinto cenario
//    @DeleteMapping(value = "/testeSimulaDeleteComNumero")
//    @ResponseBody
//    public Resposta simulaDeleteComNumero(@RequestParam UUID id) {
//        Resposta resposta = new Resposta();
//        resposta.setMensagem("Registro excluído " + id);
//        return resposta;
//    }
//
//    //Sexto cenario
//    @PutMapping(value = "/testeSimulaAtualizaComNumero")
//    @ResponseBody
//    public Resposta simulaAtualizaComNumero(@RequestParam UUID id) {
//        Resposta resposta = new Resposta();
//        resposta.setMensagem("Registro atualizado " + id);
//        return resposta;
//    }

}
