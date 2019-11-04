package tkhal.boot.bootdemo.dto;

import tkhal.boot.bootdemo.entity.Book;

public class BookDtoUtil {
    public static Book getBookDto(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setPrice(bookDto.getPrice());
        book.setYear(bookDto.getYear());
        book.setDescription(bookDto.getDescription());
        return book;
    }
}
