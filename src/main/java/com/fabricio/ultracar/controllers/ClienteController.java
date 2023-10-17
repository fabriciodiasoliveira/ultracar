package com.fabricio.ultracar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabricio.ultracar.domain.Cliente.ClienteRepository;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository;
}
