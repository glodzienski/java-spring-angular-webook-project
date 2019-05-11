package webbook.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import webbook.api.config.PublicRoute;
import webbook.api.model.Book;
import webbook.api.model.BookCategory;
import webbook.api.model.BookInfo;
import webbook.api.service.BookCategoryService;
import webbook.api.service.BookInfoService;
import webbook.api.service.BookService;
import webbook.api.util.UUIDGeneratorUtil;

@RestController
@RequestMapping("/api/book")
public class BookController implements ApiCrudControllerContract<Book> {

    @Autowired
    private BookService service;

    @Autowired
    private BookCategoryService bookCategoryService;

    @Autowired
    private BookInfoService bookInfoService;

    @PublicRoute
    @Override
    public Book store(@Valid Book book) {
        // Validando se a categoria da obra enviada existe
        BookCategory bookCategory = bookCategoryService.getByCode(book.getBookCategory().getCode());
        if (bookCategory == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria de obra não encontrada.");
        }

        // Validando informações da obra
        bookInfoService.validateSave(book.getBookInfo());

        // Criando e vinculando BookInfo
        BookInfo bookInfo = bookInfoService.store(book.getBookInfo());
        book.setBookInfo(bookInfoService.store(bookInfo));

        // Vinculando BookCategory
        book.setBookCategory(bookCategory);

        // Criando código
        book.setCode(UUIDGeneratorUtil.get());

        return service.store(book);
    }

    @Override
    public Book update(String code, @Valid Book book) {
        Book currentBook = service.getByCode(code);
        if (currentBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Obra não encontrada.");
        }

        // Validando se a categoria da obra enviada existe
        BookCategory bookCategory = bookCategoryService.getByCode(book.getBookCategory().getCode());
        if (bookCategory == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria de obra não encontrada.");
        }

        // Validando informações da obra
        bookInfoService.validateSave(book.getBookInfo());

        // Editando informação da obra
        currentBook.setBookInfo(bookInfoService.update(currentBook.getBookInfo(), book.getBookInfo()));

        // Vinculando BookCategory
        currentBook.setBookCategory(bookCategory);

        return service.update(currentBook, book);
    }

    @Override
    public Book getByCode(@PathVariable String code) {
        return service.getByCode(code);
    }

    @PublicRoute
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
        bookInfoService.destroy(book.getBookInfo());
    }
}
