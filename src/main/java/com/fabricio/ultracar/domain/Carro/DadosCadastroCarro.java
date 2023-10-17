package com.fabricio.ultracar.domain.Carro;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroCarro(
    @NotNull
    String modelo, 
    @NotNull
    String cor,
    @NotNull
    String placa,
    @NotNull
    String idCliente) {
    
}
