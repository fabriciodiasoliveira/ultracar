package com.fabricio.ultracar.domain.Cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
    Optional<Cliente> findById(String id);

    List<Cliente> findAllById(String id);

    List<Cliente> findAll();

	void deleteAllById(String id);
    
    // Page<Cliente> findAllByAtivoTrue(Pageable paginacao);

}
