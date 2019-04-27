package webbook.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webbook.api.entity.Book;
import webbook.api.repository.BookRepository;

@Service
public class BookService implements ApiCrudServiceContract<Book> {
    @Autowired
    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book store(Book book) {
        return repository.save(book);
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public Book getById(int id) {
        return null;
    }

    @Override
    public Book getByToken(String token) {
        return null;
    }

    @Override
    public Iterable<Book> list() {
        return null;
    }

    @Override
    public Book destroy(Book book) {
        return null;
    }
}
