package com.fabricio.ultracar.domain.Cliente;

import jakarta.validation.constraints.NotNull;

public record DadosAlteracaoCliente(
    @NotNull
    String id, 
    String nome, 
    String identidade, 
    String endereco) {

}
