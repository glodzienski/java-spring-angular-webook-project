package webbook.api.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;
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

    @Override
    public Book update(String code, @Valid Book book) {
        book.setCode(code);
        
        return service.update(book);
    }

    @GetMapping("{code}")
    @Override
    public Book getByCode(@PathVariable String code) {
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
