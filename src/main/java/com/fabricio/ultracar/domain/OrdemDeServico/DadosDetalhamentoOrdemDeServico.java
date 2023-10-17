package com.fabricio.ultracar.domain.OrdemDeServico;

public record DadosDetalhamentoOrdemDeServico(String id, String carro_id, String cliente_id, String servicos, String observacoes) {

    public DadosDetalhamentoOrdemDeServico(OrdemDeServico dados) {
        this(dados.getId(), dados.getCarro_id(), dados.getCliente_id(), dados.getServicos(), dados.getObservacoes());
    }
}
