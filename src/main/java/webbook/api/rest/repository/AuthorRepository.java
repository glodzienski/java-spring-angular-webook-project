package webbook.api.rest.repository;

import org.springframework.stereotype.Repository;
import webbook.api.model.entity.Author;

@Repository
public interface AuthorRepository extends BaseRepository<Author, String> {
}
