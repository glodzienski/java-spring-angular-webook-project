package webbook.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webbook.api.entity.User;
import webbook.api.repository.UserRepository;

@Service
public class UserService implements ApiCrudServiceContract<User> {
    @Autowired
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User store(User book) {
        return repository.save(book);
    }

    @Override
    public User update(User book) {
        return null;
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public User getByCode(String code) {
        return null;
    }

    @Override
    public Iterable<User> list() {
        return null;
    }

    @Override
    public User destroy(User book) {
        return null;
    }
}
