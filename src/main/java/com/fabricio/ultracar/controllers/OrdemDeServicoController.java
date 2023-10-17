package com.fabricio.ultracar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fabricio.ultracar.domain.OrdemDeServico.DadosAlteracaoOrdemDeServico;
import com.fabricio.ultracar.domain.OrdemDeServico.DadosCadastroOrdemDeServico;
import com.fabricio.ultracar.domain.OrdemDeServico.DadosDetalhamentoOrdemDeServico;
import com.fabricio.ultracar.domain.OrdemDeServico.OrdemDeServico;
import com.fabricio.ultracar.domain.OrdemDeServico.OrdemDeServicoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("servicos")
public class OrdemDeServicoController {
    @Autowired
    OrdemDeServicoRepository ordemDeServicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity store(@RequestBody @Valid DadosCadastroOrdemDeServico dados, UriComponentsBuilder uriBuilder){
        var ordemDeServicos = new OrdemDeServico(dados);
        ordemDeServicoRepository.save(ordemDeServicos);
        var uri = uriBuilder.path("/servicos/{id}").buildAndExpand(ordemDeServicos.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoOrdemDeServico(ordemDeServicos));
    }
    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoOrdemDeServico>> index(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        Page<DadosDetalhamentoOrdemDeServico> page = ordemDeServicoRepository.findAllByAtivoTrue(paginacao).map(DadosDetalhamentoOrdemDeServico::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("{id}")
    public ResponseEntity show(@PathVariable String id){
        var ordemDeServicos = ordemDeServicoRepository.findById(id);
        return ResponseEntity.ok(ordemDeServicos);
    }
    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DadosAlteracaoOrdemDeServico dados){
        List<OrdemDeServico> ordensDeServicos = ordemDeServicoRepository.findAllById(dados.id());
        OrdemDeServico ordemDeServico = ordensDeServicos.get(0);
        ordemDeServico.setDados(dados);
        ordemDeServicoRepository.save(ordemDeServico);
        return ResponseEntity.ok(new DadosDetalhamentoOrdemDeServico(ordemDeServico));
    }
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity destroi(@PathVariable String id){
        List<OrdemDeServico> ordensDeServicos = ordemDeServicoRepository.findAllById(id);
        OrdemDeServico ordemDeServico = ordensDeServicos.get(0);
        ordemDeServico.setAtivo(false);
        ordemDeServicoRepository.save(ordemDeServico);
        return ResponseEntity.ok(ordemDeServico);
    }
}
