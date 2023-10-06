package webbook.api.rest.repository;

import org.springframework.stereotype.Repository;
import webbook.api.model.entity.BookCategory;

@Repository
public interface BookCategoryRepository extends BaseRepository<BookCategory, String> {
}
