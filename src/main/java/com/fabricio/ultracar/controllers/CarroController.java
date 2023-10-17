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

import com.fabricio.ultracar.domain.Carro.Carro;
import com.fabricio.ultracar.domain.Carro.CarroRepository;
import com.fabricio.ultracar.domain.Carro.DadosAlteracaoCarro;
import com.fabricio.ultracar.domain.Carro.DadosCadastroCarro;
import com.fabricio.ultracar.domain.Carro.DadosDetalhamentoCarro;
import com.fabricio.ultracar.domain.Carro.validadores.ValidadorCarro;

import jakarta.validation.Valid;

@RestController
@RequestMapping("carros")
public class CarroController {
    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private List<ValidadorCarro> validadorCarros;

    @PostMapping
    @Transactional
    public ResponseEntity store(@RequestBody @Valid DadosCadastroCarro dados, UriComponentsBuilder uriBuilder){
        for (ValidadorCarro validadorCarro : validadorCarros) {
            validadorCarro.validar(dados);
        }
        var carro = new Carro(dados);
        carroRepository.save(carro);
        var uri = uriBuilder.path("/servicos/{id}").buildAndExpand(carro.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoCarro(carro));
    }
    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoCarro>> index(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        Page<DadosDetalhamentoCarro> page = carroRepository.findAllByAtivoTrue(paginacao).map(DadosDetalhamentoCarro::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("{id}")
    public ResponseEntity show(@PathVariable String id){
        var Carro = carroRepository.findById(id);
        return ResponseEntity.ok(Carro);
    }
    @GetMapping("{idCliente}")
    public ResponseEntity showByCliente(@PathVariable String idCliente){
        List<Carro> carros = carroRepository.findAllByIdCliente(idCliente);
        return ResponseEntity.ok(carros);
    }
    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DadosAlteracaoCarro dados){
        List<Carro> carros = carroRepository.findAllById(dados.id());
        Carro carro = carros.get(0);
        carro.setDados(dados);
        carroRepository.save(carro);
        return ResponseEntity.ok(new DadosDetalhamentoCarro(carro));
    }
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity destroy(@PathVariable String id){
        List<Carro> carros = carroRepository.findAllById(id);
        Carro carro = carros.get(0);
        carro.setAtivo(false);
        carroRepository.save(carro);
        return ResponseEntity.ok(carro);
    }

}
