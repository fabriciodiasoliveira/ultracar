package com.fabricio.ultracar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabricio.ultracar.domain.Book.Book;
import com.fabricio.ultracar.domain.Carro.Carro;
import com.fabricio.ultracar.domain.Carro.CarroRepository;

@RestController
@RequestMapping("carros")
public class CarroController {
    @Autowired
    private CarroRepository carroRepository;

    @PostMapping
    @Transactional
    public String store(@RequestBody Carro carro) {
        carroRepository.save(carro);

        return "Added Successfully";
    }

    @GetMapping
    public List<Carro> index() {

        return carroRepository.findAll();
    }

    @DeleteMapping("{id}")
    @Transactional
    public String destroy(@PathVariable String id) {
        carroRepository.deleteById(id);;

        return "Deleted Successfully";
    }
}
