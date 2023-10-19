package com.fabricio.ultracar.domain.servicos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.Valid;
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
@Document(collection = "servicos")
@EqualsAndHashCode(of = "id")
public class Servico {
    public Servico(@Valid DadosCadastroServico dados) {
        idCliente = dados.idCliente();
        servico = dados.servico();
        acao = dados.acao();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String idCliente;
    private String servico;
    private String acao;
}
