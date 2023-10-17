package com.fabricio.ultracar.domain.OrdemDeServico;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroOrdemDeServico(
    @NotNull
    String carro_id, 
    @NotNull
    String cliente_id, 
    @NotNull
    String servicos, 
    String observacoes, 
    String valor) {
    
}
