package webbook.api.repository;

import org.springframework.stereotype.Repository;
import webbook.api.model.Book;
import webbook.api.model.BookFavorite;
import webbook.api.model.User;

import java.util.ArrayList;

@Repository
public interface BookFavoriteRepository extends BaseRepository<BookFavorite, String> {
    ArrayList<BookFavorite> findAllByUser(User user);
    BookFavorite findByUserAndBook(User user, Book book);
}
