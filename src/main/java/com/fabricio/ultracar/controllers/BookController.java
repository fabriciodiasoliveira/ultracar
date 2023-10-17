package com.fabricio.ultracar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fabricio.ultracar.domain.Book.Book;
import com.fabricio.ultracar.domain.Book.BookRepository;
import java.util.List;

// Annotation 
@RestController

// Class
public class BookController {

    @Autowired
    private BookRepository repo;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book) {
        repo.save(book);

        return "Added Successfully";
    }

    @GetMapping("/findAllBooks")
    public List<Book> getBooks() {

        return repo.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        repo.deleteById(id);

        return "Deleted Successfully";
    }

}
