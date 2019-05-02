package webbook.api.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import webbook.api.entity.Book;
import webbook.api.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController implements ApiCrudControllerContract<Book> {

    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @Override
    public Book store(@Valid Book book) {
        return service.store(book);
    }

    @Override
    public Book update(String code, @Valid Book book) {
        Book currentBook = service.getByCode(code);
        if (currentBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Obra não encontrada.");
        }

        return service.update(currentBook, book);
    }

    @Override
    public Book getByCode(@PathVariable String code) {
        return service.getByCode(code);
    }

    @Override
    public Iterable<Book> list() {
        return service.list();
    }

    @Override
    public void destroy(String code) {
        Book book = service.getByCode(code);
        if (book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Obra não encontrada.");
        }

        service.destroy(book);
    }
}
