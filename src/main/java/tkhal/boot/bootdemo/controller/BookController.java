package tkhal.boot.bootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tkhal.boot.bootdemo.entity.Book;
import tkhal.boot.bootdemo.repository.BookRepository;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public String test() {
        Book java = new Book("Tutorial", 299.00, 2019);
        bookRepository.save(java);
        return "books";
    }
}
