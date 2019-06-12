package webbook.api.repository;

import org.springframework.stereotype.Repository;
import webbook.api.entity.Author;

@Repository
public interface AuthorRepository extends BaseRepository<Author, String> {
}
