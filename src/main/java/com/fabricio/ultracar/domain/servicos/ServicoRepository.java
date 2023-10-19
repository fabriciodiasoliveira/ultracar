package com.fabricio.ultracar.domain.servicos;


import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServicoRepository extends MongoRepository<Servico, String>{

    List<Servico> findAllById(String id);

	void deleteAllById(String id);
}
