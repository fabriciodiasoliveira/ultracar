package com.fabricio.ultracar.domain.Cliente;

public record DadosDetalhamentoCliente(String id, String nome, String identidade, String endereco) {

    public DadosDetalhamentoCliente(Cliente dados) {
        this(dados.getId(), dados.getNome(), dados.getIdentidade(), dados.getEndereco());
    }
    
}
