package com.fabricio.ultracar.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fabricio.ultracar.domain.OrdemDeServico.OrdemDeServico;
import com.fabricio.ultracar.domain.OrdemDeServico.OrdemDeServicoRepository;

@Component
public class OrdemDeServicoService {
    @Autowired
    OrdemDeServicoRepository ordemDeServicoRepository;

    public List<OrdemDeServico> ordemDeServicosPorCarro(String carro_id){
        List<OrdemDeServico> ordemDeServicos = ordemDeServicoRepository.findAll();
        List<OrdemDeServico> ordemDeServicosDoCliente = new ArrayList<OrdemDeServico>();
        for (OrdemDeServico ordemDeServico : ordemDeServicos) {
            if(ordemDeServico.getCarro_id().equals(carro_id)){
                ordemDeServicosDoCliente.add(ordemDeServico);
            }
        }
        return ordemDeServicosDoCliente;
    }
}
