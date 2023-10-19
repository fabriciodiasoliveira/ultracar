package com.fabricio.ultracar.domain.Cliente;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "clientes")
@EqualsAndHashCode(of = "id")
public class Cliente {
    public Cliente(@Valid DadosCadastroCliente dados) {
        nome = dados.nome();
        identidade = dados.identidade();
        endereco = dados.endereco();
        email = dados.email();
        telefone = dados.telefone();
        ativo = true;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nome;
    private String identidade;
    private String endereco;
    private String email;
    private String telefone;
    private boolean ativo;
    public void setDados(@Valid DadosAlteracaoCliente dados) {
        if(dados.nome() != null){
            nome = dados.nome();
        }
        if(identidade != null){
            identidade = dados.identidade();
        }
        if(endereco != null){
            endereco = dados.endereco();
        }
        if(email != null){
            email = dados.email();
        }
        if(telefone != null){
            telefone = dados.telefone();
        }
    }
}
