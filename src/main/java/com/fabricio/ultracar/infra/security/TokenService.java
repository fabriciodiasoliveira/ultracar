package com.fabricio.ultracar.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.fabricio.ultracar.domain.usuario.Usuario;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;
    public String gerarToken(Usuario usuario){
        try{
        var algoritmo = Algorithm.HMAC256(secret);
        return JWT.create()
            .withIssuer("Fabricio Web")
            .withClaim("id", usuario.getId())
            .withSubject(usuario.getLogin())
            .withExpiresAt(dataExpiracao())
            .sign(algoritmo);
        } catch(JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token JWT");
        }

    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
    public String getSubject(String tokenJWT){
        var algoritmo = Algorithm.HMAC256(secret);
        try{
            return JWT.require(algoritmo)
                .withIssuer("Fabricio Web")
                .build()
                .verify(tokenJWT)
                .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token inválido ou expirado"); 
        }
    }
}
