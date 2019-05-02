package webbook.api.controller;

import org.springframework.web.bind.annotation.*;
import webbook.api.entity.BookCategory;
import webbook.api.service.BookCategoryService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/book/category")
public class BookCategoryController implements ApiCrudControllerContract<BookCategory> {

    private BookCategoryService service;

    public BookCategoryController(BookCategoryService service) {
        this.service = service;
    }

    @PostMapping
    @Override
    public BookCategory store(@Valid BookCategory bookCategory) {
        return service.store(bookCategory);
    }

//    @PutMapping("teste/{code}")


    @Override
    public BookCategory update(String code, @Valid BookCategory bookCategory) {
        bookCategory.setCode(code);

        return service.update(bookCategory);
    }

    @GetMapping("{code}")
    @Override
    public BookCategory getByCode(@PathVariable String code) {
        return service.getByCode(code);
    }

    @GetMapping(produces = "application/json")
    @Override
    public Iterable<BookCategory> list() {
        return service.list();
    }

    @DeleteMapping
    @Override
    public BookCategory destroy(BookCategory bookCategory) {
        return service.destroy(bookCategory);
    }
}
