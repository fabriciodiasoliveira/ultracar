package com.fabricio.ultracar.domain.Cliente;

import jakarta.validation.constraints.NotNull;

public record DadosAlteracaoCliente(
    @NotNull
    String id, 
    @NotNull
    String nome, 
    @NotNull
    String identidade, 
    @NotNull
    String endereco) {

}
