package com.fabricio.ultracar.domain.Carro;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarroRepository extends MongoRepository<Carro, String> {

	Page<Carro> findAllByAtivoTrue(Pageable paginacao);

    Optional<Carro> findById(String id);

    List<Carro> findAllById(String id);

    List<Carro> findAllByIdCliente(String idCliente);

    List<Carro> findAllByAtivoTrue();
}
