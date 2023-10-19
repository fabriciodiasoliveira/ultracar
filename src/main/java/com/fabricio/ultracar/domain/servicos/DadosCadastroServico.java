package com.fabricio.ultracar.domain.servicos;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroServico(
    @NotNull
    String idCliente, 
    String servico, 
    String acao) {
    
}
