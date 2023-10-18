package com.fabricio.ultracar.domain.OrdemDeServico.validadores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fabricio.ultracar.domain.Cliente.Cliente;
import com.fabricio.ultracar.domain.Cliente.ClienteRepository;
import com.fabricio.ultracar.domain.OrdemDeServico.DadosCadastroOrdemDeServico;
import com.fabricio.ultracar.infra.exceptions.ValidacaoException;

@Component
public class ValidadorClienteOrdemDeServicoExiste implements ValidadorOrdemDeServico {
@Autowired
ClienteRepository clienteRepository;

    @Override
    public void validar(DadosCadastroOrdemDeServico dados) {
        List<Cliente> clientes = clienteRepository.findAllById(dados.idCliente());
        if(clientes.size() == 0){
            throw new ValidacaoException("Cliente não existe");
        }

        var cliente = clientes.get(0);
        if(cliente.isAtivo() == false){
            throw new ValidacaoException("Cliente não está ativo");
        }
    }
    
}
