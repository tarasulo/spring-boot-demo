package tkhal.boot.bootdemo.service;

import org.springframework.stereotype.Service;
import tkhal.boot.bootdemo.dto.BookDto;
import tkhal.boot.bootdemo.dto.BookDtoUtil;
import tkhal.boot.bootdemo.entity.Book;
import tkhal.boot.bootdemo.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(BookDto bookDto) {
        Book book = BookDtoUtil.getBookDto(bookDto);
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> updateById(Long bookId, BookDto bookDto) {
        if (bookRepository.existsById(bookId)) {
            Book book = BookDtoUtil.getBookDto(bookDto);
            book.setId(bookId);
            bookRepository.save(book);
            return Optional.of(book);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void delete(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
