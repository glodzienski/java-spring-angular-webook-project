package webbook.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import webbook.api.model.entity.Author;
import webbook.api.service.AuthorService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/author")
public class AuthorController implements ApiCrudControllerContract<Author> {

    @Autowired
    private AuthorService service;

    @Override
    public Author store(@Valid Author author) {
        return service.store(author);
    }

    @Override
    public Author update(String code, Author author) {
        Author currentAuthor = service.getByCode(code);
        if (currentAuthor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado.");
        }

        return service.update(currentAuthor, author);
    }

    @Override
    public Author getByCode(@PathVariable String code) {
        Author author = service.getByCode(code);
        if (author == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado.");
        }

        return author;
    }

    @Override
    public Iterable<Author> list() {
        return service.list();
    }

    @Override
    public void destroy(String code) {
        Author author = service.getByCode(code);
        if (author == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado.");
        }

        service.destroy(author);
    }
}
