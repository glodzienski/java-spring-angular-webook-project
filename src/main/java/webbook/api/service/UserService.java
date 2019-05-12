package webbook.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import webbook.api.model.User;
import webbook.api.repository.UserRepository;
import webbook.api.util.UUIDGeneratorUtil;

@Service
public class UserService implements ApiCrudServiceContract<User> {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User store(User user) {
        user.setCode(UUIDGeneratorUtil.get());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return repository.save(user);
    }

    @Override
    public User update(User currentUser, User requestUser) {
        currentUser.setBirthdayDate(requestUser.getBirthdayDate());
        currentUser.setCpf(requestUser.getCpf());
        currentUser.setName(requestUser.getName());
        currentUser.setLastName(requestUser.getLastName());
        currentUser.setPhotoUrl(requestUser.getPhotoUrl());

        return repository.save(currentUser);
    }

    @Override
    public Iterable<User> list() {
        return repository.findAll();
    }

    @Override
    public void destroy(User user) {
        repository.delete(user);
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public User getByCode(String code) {
        return repository.findByCode(code);
    }

    public User getByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User getByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
