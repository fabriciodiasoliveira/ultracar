package com.fabricio.ultracar.domain.Carro;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String modelo;
    private String cor;

}
