package webbook.api.repository;

import org.springframework.stereotype.Repository;
import webbook.api.model.BookCategory;

@Repository
public interface BookCategoryRepository extends BaseRepository<BookCategory, String> {
}
