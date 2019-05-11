package webbook.api.repository;

import org.springframework.stereotype.Repository;
import webbook.api.model.Author;

@Repository
public interface AuthorRepository extends BaseRepository<Author, String> {
}
