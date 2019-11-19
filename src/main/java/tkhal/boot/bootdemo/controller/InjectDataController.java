package tkhal.boot.bootdemo.controller;

import javax.annotation.PostConstruct;

import tkhal.boot.bootdemo.dto.BookDto;
import tkhal.boot.bootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjectDataController {

    @Autowired
    private BookService bookService;

    @PostConstruct
    public void addBooks() {
        injectLibrary();
    }

    public void injectLibrary() {
        BookDto java = new BookDto("Java Tutorial", 299.00, 2019);
        java.setDescription("Full java tutorial for users");
        bookService.save(java);
        BookDto book2 = new BookDto("Java: A Beginner's Guide, Seventh Edition", 350., 2019);
        book2.setDescription("just try it");
        bookService.save(book2);
        BookDto book3 = new BookDto("Head First Java", 99.99, 2003);
        book3.setDescription("everyone need the book");
        bookService.save(book3);
    }
}
