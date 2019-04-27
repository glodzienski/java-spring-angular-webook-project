package webbook.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webbook.api.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}
