package webbook.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import webbook.api.config.PublicRoute;
import webbook.api.model.User;
import webbook.api.service.UserService;
import webbook.api.util.CpfUtil;

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
        return service.getByCode(code);
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
