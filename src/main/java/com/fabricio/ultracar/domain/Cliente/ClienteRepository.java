package com.fabricio.ultracar.domain.Cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
    Optional<Cliente> findById(String id);

    List<Cliente> findAllById(String id);

    List<Cliente> findAll();
    // Page<Cliente> findAllByAtivoTrue(Pageable paginacao);

}
