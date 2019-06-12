package webbook.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import webbook.api.helper.AuthHelper;
import webbook.api.config.PublicRoute;
import webbook.api.dto.AuthInfoDTO;
import webbook.api.dto.AuthLoginDTO;
import webbook.api.dto.AuthTokenDTO;
import webbook.api.entity.AuthToken;
import webbook.api.entity.User;
import webbook.api.service.AuthService;
import webbook.api.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @PublicRoute
    @PostMapping("login")
    public AuthTokenDTO login(@RequestBody @Valid AuthLoginDTO authLoginDTO) {
        User user = userService.getByEmail(authLoginDTO.email);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário com email " + authLoginDTO.email + " não cadastrado na plataforma.");
        }

        if (authService.validatePassword(authLoginDTO, user)) {
            AuthToken currentAuthToken = authService.getActiveAuthTokenOfUser(user);
            if (currentAuthToken != null) {
                authService.invalidateAuthToken(currentAuthToken);
            }

            AuthToken authToken = authService.createAuthToken(user);

            return new AuthTokenDTO(authToken.getToken());
        }

        throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Dados de login informados estão incorretos.");
    }

    @PostMapping("logout")
    public void logout() {
        authService.invalidateAuthToken(AuthHelper.authToken());
    }

    @PostMapping("validate")
    public AuthInfoDTO validate(@RequestBody @Valid AuthTokenDTO authTokenDTO) {
        AuthToken authToken = authService.getByTokenActive(authTokenDTO.token);

        AuthInfoDTO authInfoDTO = new AuthInfoDTO();
        authInfoDTO.user = authToken.getUser();

        return authInfoDTO;
    }
}
