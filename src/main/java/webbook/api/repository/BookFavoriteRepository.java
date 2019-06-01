package webbook.api.repository;

import org.springframework.stereotype.Repository;
import webbook.api.model.BookFavorite;

@Repository
public interface BookFavoriteRepository extends BaseRepository<BookFavorite, String> {
}
