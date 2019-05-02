package webbook.api.controller;

import org.springframework.web.bind.annotation.*;
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
        user.setCode(code);

        return service.update(user);
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

    @DeleteMapping
    @Override
    public User destroy(User user) {
        return service.destroy(user);
    }
}