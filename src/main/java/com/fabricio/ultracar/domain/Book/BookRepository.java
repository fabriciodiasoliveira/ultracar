package com.fabricio.ultracar.domain.Book;
// Java Program to Illustrate BookRepo File
 
import org.springframework.data.mongodb.repository.MongoRepository;
 
public interface BookRepository
    extends MongoRepository<Book, Integer> {

}