package webbook.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import webbook.api.core.helper.AuthHelper;
import webbook.api.model.entity.Book;
import webbook.api.model.entity.BookFavorite;
import webbook.api.rest.service.BookFavoriteService;
import webbook.api.rest.service.BookService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/book/favorite")
public class BookFavoriteController implements ApiCrudControllerContract<BookFavorite> {

    @Autowired
    private BookFavoriteService service;

    @Autowired
    private BookService bookService;

    @Override
    public BookFavorite store(@Valid BookFavorite bookFavorite) {
        Book book = bookService.getByCode(bookFavorite.getBook().getCode());
        if (book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Obra não encontrada.");
        }
        if (service.validateIfBookHasAlreadyFavoritedByUser(book, AuthHelper.user())) {
            return null;
        }

        bookFavorite.setBook(book);
        bookFavorite.setUser(AuthHelper.user());

        return service.store(bookFavorite);
    }

    @Override
    public BookFavorite update(String code, @Valid BookFavorite bookFavorite) {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public BookFavorite getByCode(@PathVariable String code) {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public Iterable<BookFavorite> list() {
        return service.list();
    }

    @Override
    public void destroy(String code) {
        BookFavorite bookFavorite = service.getByCode(code);
        if (bookFavorite == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Favorito não encontrado.");
        }

        service.destroy(bookFavorite);
    }
}
