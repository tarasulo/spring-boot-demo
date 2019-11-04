package tkhal.boot.bootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tkhal.boot.bootdemo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
