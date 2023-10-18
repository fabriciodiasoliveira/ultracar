package com.fabricio.ultracar.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fabricio.ultracar.domain.Carro.Carro;
import com.fabricio.ultracar.domain.Carro.CarroRepository;

@Component
public class CarroService {
    @Autowired
    CarroRepository carroRepository;

    public List<Carro> carrosDoCliente(String idCliente){
        List<Carro> carros = carroRepository.findAllByAtivoTrue();
        List<Carro> carrosDoCliente = new ArrayList<Carro>();
        for (Carro carro : carros) {
            if(carro.getIdCliente().equals(idCliente)){
                carrosDoCliente.add(carro);
                System.out.println("passou aqui");
            }
        }
        return carrosDoCliente;
    }
}
