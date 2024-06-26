package com.example.book_by_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.book_by_spring.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);

    @Query("SELECT b FROM Book b WHERE b.price > :priceLar")
    List<Book> findBookHasPriceLarger(@Param("price") int priceLar);
}
