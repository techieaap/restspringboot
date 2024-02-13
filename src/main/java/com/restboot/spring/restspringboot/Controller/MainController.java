package com.restboot.spring.restspringboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restboot.spring.restspringboot.entity.Books;
import com.restboot.spring.restspringboot.services.BookServices;

@RestController
public class MainController {

    @Autowired
    private BookServices bookServices;

    @GetMapping("/book")
    public List<Books> getAllBooks(){
        return this.bookServices.getallBooks();
    }
    @GetMapping("/book/{id}")
    public Books getBook(@PathVariable("id")int id){
        return this.bookServices.getBookById(id);
    }

    @PostMapping("/book")
    public Books addBooks(@RequestBody Books book){
        Books b=this.bookServices.addBook(book);
        System.out.println(book);
        return b;
    }
    
}
