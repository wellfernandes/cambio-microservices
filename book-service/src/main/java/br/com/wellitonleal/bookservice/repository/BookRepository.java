package br.com.wellitonleal.bookservice.repository;

import br.com.wellitonleal.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{
}
