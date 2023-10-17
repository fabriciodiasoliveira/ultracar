package com.fabricio.ultracar.domain.OrdemDeServico;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrdemDeServicoRepository extends MongoRepository<OrdemDeServico, String> {
    Page<OrdemDeServico> findAll(Pageable paginacao);

    Optional<OrdemDeServico> findById(String id);

    List<OrdemDeServico> findAllById(String id);

    Page<OrdemDeServico> findAllByAtivoTrue(Pageable paginacao);

}
