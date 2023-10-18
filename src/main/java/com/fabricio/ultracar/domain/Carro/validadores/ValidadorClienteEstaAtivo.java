package com.fabricio.ultracar.domain.Carro.validadores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fabricio.ultracar.domain.Carro.DadosCadastroCarro;
import com.fabricio.ultracar.domain.Cliente.Cliente;
import com.fabricio.ultracar.domain.Cliente.ClienteRepository;
import com.fabricio.ultracar.infra.exceptions.ValidacaoException;

@Component
public class ValidadorClienteEstaAtivo implements ValidadorCarro {
    
@Autowired
ClienteRepository clienteRepository;

    @Override
    public void validar(DadosCadastroCarro dados) {
        List<Cliente> clientes = clienteRepository.findAllById(dados.idCliente());
        var cliente = clientes.get(0);
        if(cliente.isAtivo() == false){
            throw new ValidacaoException("Cliente não está ativo");
        }
    }
    
}
