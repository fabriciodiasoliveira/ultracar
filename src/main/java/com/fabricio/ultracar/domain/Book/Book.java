package com.fabricio.ultracar.domain.Book;
// Java Program to illustrate Book File

// Importing required classes
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "Book")

// Class
public class Book 
{

	// Attributes
	@Id private int id;
	private String bookName;
	private String authorName;
	public void atualizar(DadosAtualizarBook dados) {
	}
}
