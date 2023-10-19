package com.fabricio.ultracar.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fabricio.ultracar.domain.servicos.Servico;
import com.fabricio.ultracar.domain.servicos.ServicoRepository;

@Component
public class ServicoService {
    @Autowired
    ServicoRepository servicoRepository;
    
        public List<Servico> servicosDoCliente(String idCliente){
            List<Servico> servicos = servicoRepository.findAll();
            List<Servico> servicosDoCliente = new ArrayList<Servico>();
            for (Servico servico : servicos) {
                if(servico.getIdCliente().equals(idCliente)){
                    servicosDoCliente.add(servico);
                }
            }
            return servicosDoCliente;
        }
}
