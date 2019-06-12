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
    public Book update(Book currentBook, Book requestBook) {
        currentBook.setActive(requestBook.getActive());
        currentBook.setFilePath(requestBook.getFilePath());
        currentBook.setName(requestBook.getName());

        return repository.save(currentBook);
    }

    @Override
    public Book getById(int id) {
        return null;
    }

    @Override
    public Book getByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public Iterable<Book> list() {
        return repository.findAll();
    }

    @Override
    public void destroy(Book book) {
        repository.delete(book);
    }
}
