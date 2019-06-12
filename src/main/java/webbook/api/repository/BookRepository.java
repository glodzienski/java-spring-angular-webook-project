package webbook.api.repository;

import org.springframework.stereotype.Repository;
import webbook.api.model.entity.Book;

@Repository
public interface BookRepository extends BaseRepository<Book, String> {
}
