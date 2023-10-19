package com.fabricio.ultracar.domain.Carro;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroCarro(
    @NotNull
    String modelo, 
    String placa,
    @NotNull
    String idCliente) {
    
}
