package com.fabricio.ultracar.domain.Carro;

public record DadosDetalhamentoCarro(String id, String modelo, String cor, String placa) {

    public DadosDetalhamentoCarro(Carro carro) {
        this(carro.getId(), carro.getModelo(), carro.getCor(), carro.getPlaca());
    }
    
}
