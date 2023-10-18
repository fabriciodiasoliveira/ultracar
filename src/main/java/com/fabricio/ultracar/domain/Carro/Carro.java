package com.fabricio.ultracar.domain.Carro;

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
@Document(collection = "carros")
@EqualsAndHashCode(of = "id")
public class Carro {
    public Carro(@Valid DadosCadastroCarro dados) {
        idCliente = dados.idCliente();
        modelo = dados.modelo();
        cor = dados.cor();
        placa = dados.placa();
        ativo = true;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String idCliente;
    private String modelo;
    private String cor;
    private String placa;
    private boolean ativo;
    public void setDados(@Valid DadosAlteracaoCarro dados) {
        if(dados.modelo() != null){
            modelo = dados.modelo();
        }
        if(dados.cor() != null){
            cor = dados.cor();
        }
        if(dados.placa() != null){
            placa = dados.placa();
        }
    }
}
