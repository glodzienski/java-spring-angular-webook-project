package webbook.api.rest.repository;

import org.springframework.stereotype.Repository;
import webbook.api.model.entity.Book;
import webbook.api.model.entity.BookFavorite;
import webbook.api.model.entity.User;

import java.util.ArrayList;

@Repository
public interface BookFavoriteRepository extends BaseRepository<BookFavorite, String> {
    ArrayList<BookFavorite> findAllByUser(User user);
    BookFavorite findByUserAndBook(User user, Book book);
}
