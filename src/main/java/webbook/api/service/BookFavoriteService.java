package webbook.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webbook.api.helper.UUIDGeneratorHelper;
import webbook.api.model.BookFavorite;
import webbook.api.repository.BookFavoriteRepository;

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
        return null;
    }

    @Override
    public Iterable<BookFavorite> list() {
        return null;
    }

    @Override
    public void destroy(BookFavorite bookFavorite) {
        repository.delete(bookFavorite);
    }
}
