package com.fabricio.ultracar.domain.OrdemDeServico;

import jakarta.validation.constraints.NotNull;

public record DadosAlteracaoOrdemDeServico(
    @NotNull
    String id, 
    String servicos, 
    String observacoes, 
    String valor) {
    
}
