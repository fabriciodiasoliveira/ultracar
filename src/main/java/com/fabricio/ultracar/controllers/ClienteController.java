package com.fabricio.ultracar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fabricio.ultracar.domain.Cliente.Cliente;
import com.fabricio.ultracar.domain.Cliente.ClienteRepository;
import com.fabricio.ultracar.domain.Cliente.DadosAlteracaoCliente;
import com.fabricio.ultracar.domain.Cliente.DadosCadastroCliente;
import com.fabricio.ultracar.domain.Cliente.DadosDetalhamentoCliente;
import com.fabricio.ultracar.domain.OrdemDeServico.DadosDetalhamentoOrdemDeServico;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity store(@RequestBody @Valid DadosCadastroCliente dados, UriComponentsBuilder uriBuilder){
        var cliente = new Cliente(dados);
        clienteRepository.save(cliente);
        var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));
    }
    @GetMapping
    public ResponseEntity<List<Cliente>> index(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }
    @GetMapping("{id}")
    public ResponseEntity show(@PathVariable String id){
        var cliente = clienteRepository.findById(id);
        return ResponseEntity.ok(cliente);
    }
    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DadosAlteracaoCliente dados){
        List<Cliente> ordensDeServicos = clienteRepository.findAllById(dados.id());
        Cliente cliente = ordensDeServicos.get(0);
        cliente.setDados(dados);
        clienteRepository.save(cliente);
        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity destroi(@PathVariable String id){
        List<Cliente> clientes = clienteRepository.findAllById(id);
        Cliente cliente = clientes.get(0);
        clienteRepository.deleteById(id);
        return ResponseEntity.ok(cliente);
    }

}
