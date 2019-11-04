package tkhal.boot.bootdemo.controller;

import org.springframework.web.bind.annotation.*;
import tkhal.boot.bootdemo.dto.BookDto;
import tkhal.boot.bootdemo.entity.Book;
import tkhal.boot.bootdemo.service.BookService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{bookId}")
    public Book getById(@PathVariable("bookId") Long id) {
        return bookService.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find book by id " + id));
    }

    @PostMapping
    public void add(@Valid @RequestBody BookDto bookDto) {
        bookService.save(bookDto);
    }

    @DeleteMapping("/{bookId}")
    public void delete(@PathVariable("bookId") Long bookId) {
        bookService.delete(bookId);
    }

    @PutMapping("/{bookId}")
    public Book update(@PathVariable("bookId") Long id, @Valid @RequestBody BookDto bookDto) {
        Optional<Book> book = bookService.updateById(id, bookDto);
        return book.orElseThrow(
                () -> new EntityNotFoundException("Can't update book by id " + id));
    }

    @GetMapping
    public List<Book> allBooks() {
        return bookService.findAll();
    }

}
