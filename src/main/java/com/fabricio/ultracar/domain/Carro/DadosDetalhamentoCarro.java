package com.fabricio.ultracar.domain.Carro;

public record DadosDetalhamentoCarro(String id, String modelo, String placa, String idCliente) {

    public DadosDetalhamentoCarro(Carro carro) {
        this(carro.getId(), carro.getModelo(), carro.getPlaca(), carro.getIdCliente());
    }
    
}
