package com.fabricio.ultracar.domain.Cliente;

public record DadosDetalhamentoCliente(String id, String nome, String identidade, String endereco, String email, String telefone) {

    public DadosDetalhamentoCliente(Cliente dados) {
        this(dados.getId(), dados.getNome(), dados.getIdentidade(), dados.getEndereco(), dados.getEmail(), dados.getTelefone());
    }
    
}
