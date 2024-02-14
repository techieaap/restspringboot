package com.restboot.spring.restspringboot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;

import com.restboot.spring.restspringboot.entity.Books;
@Component
public class BookServices {
    private static List<Books>list=new ArrayList<>();
    static {
        list.add(new Books(1234,"javaSpring","Parihar"));
        list.add(new Books(1235,"javaSpring bot","Xiao"));
        list.add(new Books(1236,"javaSpring frame","Dre"));
        list.add(new Books(1237,"javaSpring work","Han"));
    }
    public List<Books> getallBooks(){
        return list;
    }
    public Books getBookById(int id){
        Books book=null;
        book=list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }

    public Books addBook(Books b){
        list.add(b);
        return b;
    }

    public void deleteBook(int bid){
        list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
    }
     public void updateBook(Books book,int bookId){
        list=list.stream().map(b->{
            if(b.getId()==bookId){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
     }
   
}
