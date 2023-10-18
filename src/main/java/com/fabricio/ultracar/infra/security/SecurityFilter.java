package com.fabricio.ultracar.infra.security;

import java.io.IOException;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fabricio.ultracar.domain.usuario.UsuarioRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    TokenService tokenService;

    @Autowired
    private UsuarioRepository repository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'doFilterInternal'");
        var url = request.getRequestURL();
        var tokenJWT = recuperarToken(request);
        if(tokenJWT != null){
            var subject = tokenService.getSubject(tokenJWT);
            var usuario = repository.findByLogin(subject);
            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else if(url.indexOf("login") == -1){
            throw new AuthorizationServiceException("Permissão negada");
        }
        filterChain.doFilter(request, response);
    }
    public String recuperarToken(HttpServletRequest request){
        var autorizationReader = request.getHeader("Authorization");
        if(autorizationReader != null){
            return request.getHeader("Authorization").replace("Bearer ", "");
        }
        return null;
    }
}
