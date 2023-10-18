package com.fabricio.ultracar.domain.usuario;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends MongoRepository <Usuario, String> {

    public UserDetails findByLogin(String username);
    
}
