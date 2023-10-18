package com.fabricio.ultracar.domain.OrdemDeServico;

public record DadosDetalhamentoOrdemDeServico(String id, String carro_id, String idCliente, String servicos, String observacoes, String valor, String data) {

    public DadosDetalhamentoOrdemDeServico(OrdemDeServico dados) {
        this(dados.getId(), dados.getCarro_id(), dados.getIdCliente(), dados.getServicos(), dados.getObservacoes(), dados.getValor(), dados.getData());
    }
}
