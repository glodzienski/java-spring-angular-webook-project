package webbook.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import webbook.api.entity.User;
import webbook.api.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController implements ApiCrudControllerContract<User> {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    @Override
    public User store(@Valid User user) {
        return service.store(user);
    }

    @Override
    public User update(String code, @Valid User user) {
        User currentUser = service.getByCode(code);
        if (currentUser == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado.");
        }

        return service.update(currentUser, user);
    }

    @GetMapping(value = "{code}")
    @Override
    public User getByCode(@PathVariable String code) {
        return service.getByCode(code);
    }

    @GetMapping(produces = "application/json")
    @Override
    public Iterable<User> list() {
        return service.list();
    }

    @Override
    public void destroy(String code) {
        User user = service.getByCode(code);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado.");
        }

        service.destroy(user);
    }
}
