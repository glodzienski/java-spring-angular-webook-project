package webbook.api.repository;

import org.springframework.stereotype.Repository;
import webbook.api.entity.Book;
import webbook.api.entity.BookFavorite;
import webbook.api.entity.User;

import java.util.ArrayList;

@Repository
public interface BookFavoriteRepository extends BaseRepository<BookFavorite, String> {
    ArrayList<BookFavorite> findAllByUser(User user);
    BookFavorite findByUserAndBook(User user, Book book);
}
