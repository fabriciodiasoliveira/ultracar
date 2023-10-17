package com.fabricio.ultracar.domain.OrdemDeServico;

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
@Document(collection = "ultracar")
@EqualsAndHashCode(of = "id")
public class OrdemDeServico {
    public OrdemDeServico(@Valid DadosCadastroOrdemDeServico dados) {
        carro_id = dados.carro_id();
        cliente_id = dados.cliente_id();
        servicos = dados.servicos();
        observacoes = dados.observacoes();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
	private String carro_id;
    private String cliente_id;
    private String servicos;
    private String observacoes;
}
