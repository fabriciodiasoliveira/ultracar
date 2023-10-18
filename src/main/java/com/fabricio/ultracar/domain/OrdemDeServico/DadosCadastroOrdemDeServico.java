package com.fabricio.ultracar.domain.OrdemDeServico;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroOrdemDeServico(
    @NotNull
    String carro_id, 
    @NotNull
    String idCliente, 
    @NotNull
    String servicos,
    String observacoes, 
    String valor) {
    
}
