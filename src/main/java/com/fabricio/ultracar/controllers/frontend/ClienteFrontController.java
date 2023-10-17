package com.fabricio.ultracar.controllers.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fabricio.ultracar.domain.Cliente.ClienteRepository;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("carros")
public class ClienteFrontController {
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("index")
    public String index(Model model){
        var clientes = clienteRepository.findAll();

        return "carros/index";
    }
}
