package webbook.api.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webbook.api.core.helper.AuthHelper;
import webbook.api.core.helper.UUIDGeneratorHelper;
import webbook.api.model.entity.Book;
import webbook.api.model.entity.BookFavorite;
import webbook.api.model.entity.User;
import webbook.api.rest.repository.BookFavoriteRepository;

@Service
public class BookFavoriteService implements ApiCrudServiceContract<BookFavorite> {
    @Autowired
    private BookFavoriteRepository repository;

    @Override
    public BookFavorite store(BookFavorite bookFavorite) {
        bookFavorite.setCode(UUIDGeneratorHelper.get());

        return repository.save(bookFavorite);
    }

    @Override
    public BookFavorite update(BookFavorite currentBookFavorite, BookFavorite requestBookFavorite) {
        return null;
    }

    @Override
    public BookFavorite getById(int id) {
        return null;
    }

    @Override
    public BookFavorite getByCode(String code) {
        return repository.findByCode(code);
    }

    public Boolean validateIfBookHasAlreadyFavoritedByUser(Book book, User user) {
        BookFavorite bookFavorite = repository.findByUserAndBook(user, book);

        return bookFavorite != null;
    }

    @Override
    public Iterable<BookFavorite> list() {
        return repository.findAllByUser(AuthHelper.user());
    }

    @Override
    public void destroy(BookFavorite bookFavorite) {
        repository.delete(bookFavorite);
    }
}
