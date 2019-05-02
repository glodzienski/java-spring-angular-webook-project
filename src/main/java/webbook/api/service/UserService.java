package webbook.api.service;

import org.jetbrains.annotations.Contract;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webbook.api.entity.User;
import webbook.api.repository.UserRepository;
import webbook.api.util.UUIDGeneratorUtil;

@Service
public class UserService implements ApiCrudServiceContract<User> {
    @Autowired
    private UserRepository repository;

    @Contract(pure = true)
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User store(User user) {
        user.setCode(UUIDGeneratorUtil.get());
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));

        return repository.save(user);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public User getByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public Iterable<User> list() {
        return null;
    }

    @Override
    public User destroy(User user) {
        return null;
    }
}
