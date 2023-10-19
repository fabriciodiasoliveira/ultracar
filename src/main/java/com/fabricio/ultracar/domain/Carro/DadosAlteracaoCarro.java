package com.fabricio.ultracar.domain.Carro;

import jakarta.validation.constraints.NotNull;

public record DadosAlteracaoCarro(
    @NotNull
    String id,
    String modelo, 
    String placa) {
    
}
