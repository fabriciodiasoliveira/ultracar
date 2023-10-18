package com.fabricio.ultracar.domain.OrdemDeServico.validadores;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fabricio.ultracar.domain.Carro.Carro;
import com.fabricio.ultracar.domain.Carro.CarroRepository;
import com.fabricio.ultracar.domain.OrdemDeServico.DadosCadastroOrdemDeServico;
import com.fabricio.ultracar.infra.exceptions.ValidacaoException;

public class ValidadorCarroExiste implements ValidadorOrdemDeServico {
@Autowired
CarroRepository carroRepository;

    @Override
    public void validar(DadosCadastroOrdemDeServico dados) {
        List<Carro> carros = carroRepository.findAllById(dados.carro_id());
        if(carros.size() == 0){
            throw new ValidacaoException("Carro não existe");
        }

        var carro = carros.get(0);
        if(carro.isAtivo() == false){
            throw new ValidacaoException("Carro não está ativo");
        }
    }
}
