package webbook.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import webbook.api.model.entity.BookCategory;
import webbook.api.rest.service.BookCategoryService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/book/category")
public class BookCategoryController implements ApiCrudControllerContract<BookCategory> {

    @Autowired
    private BookCategoryService service;

    @Override
    public BookCategory store(@Valid BookCategory bookCategory) {
        return service.store(bookCategory);
    }

    @Override
    public BookCategory update(String code, @Valid BookCategory bookCategory) {
        BookCategory currentBookCategory = service.getByCode(code);
        if (currentBookCategory == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria de livro solicitada não encontrada.");
        }

        return service.update(currentBookCategory, bookCategory);
    }

    @Override
    public BookCategory getByCode(@PathVariable String code) {
        BookCategory bookCategory = service.getByCode(code);
        if (bookCategory == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria de livro solicitada não encontrada.");
        }

        return bookCategory;
    }

    @Override
    public Iterable<BookCategory> list() {
        return service.list();
    }

    @Override
    public void destroy(String code) {
        BookCategory bookCategory = service.getByCode(code);
        if (bookCategory == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria de livro solicitada não encontrada.");
        }

        service.destroy(bookCategory);
    }
}
