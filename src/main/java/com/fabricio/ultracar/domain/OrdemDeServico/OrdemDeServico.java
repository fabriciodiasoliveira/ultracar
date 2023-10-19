package com.fabricio.ultracar.domain.OrdemDeServico;

import java.time.LocalDateTime;

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
@Document(collection = "ordem_de_servicos")
@EqualsAndHashCode(of = "id")
public class OrdemDeServico {
    public OrdemDeServico(@Valid DadosCadastroOrdemDeServico dados) {
        carro_id = dados.carro_id();
        servicos = dados.servicos();
        observacoes = dados.observacoes();
        if(dados.valor() != null){
            valor = dados.valor();
        }
        else{
            valor = "0";
        }
        funcionario = dados.funcionario();
        data = LocalDateTime.now().toString();
        ativo = true;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
	private String carro_id;
    private String funcionario;
    private String servicos;
    private String observacoes;
    private String valor;
    private String data;
    private boolean ativo;
    
    public void setDados(@Valid DadosAlteracaoOrdemDeServico dados) {
        if(dados.servicos() != null){
            servicos = dados.servicos();
        }
        if(dados.observacoes() != null){
            observacoes = dados.observacoes();
        }
        if(dados.funcionario() != null){
            funcionario = dados.funcionario();
        }
        if(dados.valor() != null){
            valor = dados.valor();
        }
        else{
            valor = "0";
        }
        
    }
}
