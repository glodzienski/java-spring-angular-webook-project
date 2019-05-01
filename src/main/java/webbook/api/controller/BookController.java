package webbook.api.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webbook.api.entity.Book;
import webbook.api.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController implements ApiCrudControllerContract<Book> {

    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    @Override
    public Book store(@Valid Book book) {
        return service.store(book);
    }

    @PutMapping
    @Override
    public Book update(@Valid Book book) {
        return service.update(book);
    }

    @GetMapping("{code}")
    @Override
    public Book getByCode(String code) {
        return service.getByCode(code);
    }

    @GetMapping(produces = "application/json")
    @Override
    public Iterable<Book> list() {
        return service.list();
    }

    @DeleteMapping
    @Override
    public Book destroy(Book book) {
        return service.destroy(book);
    }
}
