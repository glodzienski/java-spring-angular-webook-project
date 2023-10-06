package webbook.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import webbook.api.core.config.PublicRoute;
import webbook.api.model.entity.User;
import webbook.api.rest.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController implements ApiCrudControllerContract<User> {

    @Autowired
    private UserService service;

    @Override
    @PublicRoute
    public User store(@Valid User user) {
        if (user.getPassword().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Por favor informe uma senha válida para se cadastrar no sistema.");
        }
        service.validateUserInfo(user, false);

        return service.store(user);
    }

    @Override
    public User update(String code, @Valid User user) {
        User currentUser = service.getByCode(code);
        if (currentUser == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado.");
        }
        service.validateUserInfo(user, true);

        return service.update(currentUser, user);
    }

    @Override
    public User getByCode(@PathVariable String code) {
        User user = service.getByCode(code);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado.");
        }

        return user;
    }

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
