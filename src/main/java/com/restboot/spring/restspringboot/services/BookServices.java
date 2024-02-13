package com.restboot.spring.restspringboot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

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
}
