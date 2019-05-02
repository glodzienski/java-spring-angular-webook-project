package webbook.api.service;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import webbook.api.entity.BookCategory;
import webbook.api.repository.BookCategoryRepository;
import webbook.api.util.UUIDGeneratorUtil;

@Service
public class BookCategoryService implements ApiCrudServiceContract<BookCategory> {
    @Autowired
    private BookCategoryRepository repository;

    public BookCategoryService(BookCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public BookCategory store(BookCategory bookCategory) {
        bookCategory.setCode(UUIDGeneratorUtil.get());
        return repository.save(bookCategory);
    }

    @Override
    public BookCategory update(BookCategory bookCategory) {
        BookCategory currentBookCategory = repository.findByCode(bookCategory.getCode());

        if (currentBookCategory == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria de livro solicitada não encontrada.");
        }

        currentBookCategory.setName(bookCategory.getName());
        currentBookCategory.setDescription(bookCategory.getDescription());

        return repository.save(currentBookCategory);
    }

    @Override
    public BookCategory getById(int id) {
        return null;
    }

    @Override
    public BookCategory getByCode(String code) {
        return null;
    }

    @Override
    public Iterable<BookCategory> list() {
        return null;
    }

    @Override
    public BookCategory destroy(BookCategory bookCategory) {
        return null;
    }
}
