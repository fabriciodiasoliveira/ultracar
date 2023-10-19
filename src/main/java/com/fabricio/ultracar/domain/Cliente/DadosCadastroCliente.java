package com.fabricio.ultracar.domain.Cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCliente(
    @NotNull
    String nome, 
    @NotNull
    String identidade, 
    @NotNull
    @Email
    String email,
    @NotNull
    String telefone,
    @NotNull
    String endereco) {
    
}
