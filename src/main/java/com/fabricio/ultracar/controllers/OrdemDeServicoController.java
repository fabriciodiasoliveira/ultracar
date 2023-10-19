package com.fabricio.ultracar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import com.fabricio.ultracar.domain.OrdemDeServico.validadores.ValidadorOrdemDeServico;
import com.fabricio.ultracar.services.OrdemDeServicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("servicos")
public class OrdemDeServicoController {
    @Autowired
    OrdemDeServicoRepository ordemDeServicoRepository;

    @Autowired
    OrdemDeServicoService ordemDeServicoService;

    @Autowired
    private List<ValidadorOrdemDeServico> validadorOrdemDeServicos;

    @PostMapping
    @Transactional
    public ResponseEntity store(@RequestBody @Valid DadosCadastroOrdemDeServico dados, UriComponentsBuilder uriBuilder){
        for (ValidadorOrdemDeServico validadorOrdemDeServico : validadorOrdemDeServicos) {
            validadorOrdemDeServico.validar(dados);
        }
        var ordemDeServicos = new OrdemDeServico(dados);
        ordemDeServicoRepository.save(ordemDeServicos);
        var uri = uriBuilder.path("/servicos/{id}").buildAndExpand(ordemDeServicos.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoOrdemDeServico(ordemDeServicos));
    }
    @GetMapping
    public List<OrdemDeServico> index(){
        List<OrdemDeServico> ordemDeServicos = ordemDeServicoRepository.findAll();
        return ordemDeServicos;
    }
    @GetMapping("paginacao")
    public ResponseEntity<Page<DadosDetalhamentoOrdemDeServico>> indexPaginacao(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        Page<DadosDetalhamentoOrdemDeServico> page = ordemDeServicoRepository.findAllByAtivoTrue(paginacao).map(DadosDetalhamentoOrdemDeServico::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("{id}")
    public ResponseEntity show(@PathVariable String id){
        var ordemDeServicos = ordemDeServicoRepository.findById(id);
        return ResponseEntity.ok(ordemDeServicos);
    }
    @GetMapping("carro/{id}")
    public ResponseEntity ordemDeServicoPorCarro(@PathVariable String id){
        var ordemDeServicos = ordemDeServicoService.ordemDeServicosPorCarro(id);
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
    public ResponseEntity destroy(@PathVariable String id){
        ordemDeServicoRepository.deleteAllById(id);
        return ResponseEntity.noContent().build();
    }
}
