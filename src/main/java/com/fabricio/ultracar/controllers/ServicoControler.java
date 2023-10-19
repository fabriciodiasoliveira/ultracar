package com.fabricio.ultracar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fabricio.ultracar.domain.servicos.DadosCadastroServico;
import com.fabricio.ultracar.domain.servicos.Servico;
import com.fabricio.ultracar.domain.servicos.ServicoRepository;
import com.fabricio.ultracar.services.ServicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("servicoscliente")
public class ServicoControler {
    @Autowired
    ServicoService servicoService;

    @Autowired
    ServicoRepository servicoRepository;

    @GetMapping("{idCliente}")
    public List<Servico> index(@PathVariable String idCliente){
        return servicoService.servicosDoCliente(idCliente);
    }
    @PostMapping
    public ResponseEntity store(@RequestBody @Valid DadosCadastroServico dados, UriComponentsBuilder uriBuilder){
        var servico = new Servico(dados);
        servicoRepository.save(servico);
        var uri = uriBuilder.path("/servicos/{id}").buildAndExpand(servico.getId()).toUri();

        return ResponseEntity.created(uri).body(servico);
    }
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity destroy(@PathVariable String id){
        servicoRepository.deleteAllById(id);
        return ResponseEntity.noContent().build();
    }
}
