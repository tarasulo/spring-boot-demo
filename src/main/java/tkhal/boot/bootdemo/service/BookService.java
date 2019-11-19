package tkhal.boot.bootdemo.service;

import tkhal.boot.bootdemo.dto.BookDto;
import tkhal.boot.bootdemo.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book save(BookDto bookDto);

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> updateById(Long bookId, BookDto bookDto);

    void delete(Long bookId);

}
