package webbook.api.service;

import org.jetbrains.annotations.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webbook.api.model.entity.Author;
import webbook.api.repository.AuthorRepository;
import webbook.api.helper.UUIDGeneratorHelper;

@Service
public class AuthorService implements ApiCrudServiceContract<Author> {
    @Autowired
    private AuthorRepository repository;

    @Contract(pure = true)
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Author store(Author author) {
        author.setCode(UUIDGeneratorHelper.get());

        return repository.save(author);
    }

    @Override
    public Author update(Author currentAuthor, Author requestAuthor) {
        currentAuthor.setDateBirthday(requestAuthor.getDateBirthday());
        currentAuthor.setName(requestAuthor.getName());
        currentAuthor.setLastName(requestAuthor.getLastName());
        currentAuthor.setWikipediaLink(requestAuthor.getWikipediaLink());

        return repository.save(currentAuthor);
    }

    @Override
    public Author getById(int id) {
        return null;
    }

    @Override
    public Author getByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public Iterable<Author> list() {
        return repository.findAll();
    }

    @Override
    public void destroy(Author author) {
        repository.delete(author);
    }
}
