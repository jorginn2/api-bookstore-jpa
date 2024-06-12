package com.bookstore.jpa.repositorys;

import com.bookstore.jpa.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<BookModel, UUID> {

    BookModel findBookModelByTitle(String title); //é possível concatenar a consulta com AND/OR

    @Query(value = "SELECT * FROM tb_book WHERE publisher_id= :id", nativeQuery = true)
    List<BookModel> findBookByPublisherId(@Param("id") UUID id);
}
