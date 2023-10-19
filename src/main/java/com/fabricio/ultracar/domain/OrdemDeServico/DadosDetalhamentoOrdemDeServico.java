package com.fabricio.ultracar.domain.OrdemDeServico;

public record DadosDetalhamentoOrdemDeServico(String id, String carro_id, String servicos, String observacoes, String valor, String data, String funcionario) {

    public DadosDetalhamentoOrdemDeServico(OrdemDeServico dados) {
        this(dados.getId(), dados.getCarro_id(), dados.getServicos(), dados.getObservacoes(), dados.getValor(), dados.getData(), dados.getFuncionario());
    }
}
