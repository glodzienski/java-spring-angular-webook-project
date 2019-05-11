package webbook.api.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import webbook.api.model.AuthToken;
import webbook.api.model.User;

public class AuthSingleton {
    private static User loggedUser;

    private static AuthToken authToken;

    private static void initializeUserByAuthToke() {
        if (authToken == null) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Erro com a autenticação do usuário.");
        }

        loggedUser = authToken.getUser();
    }

    public static User user() {
        if (loggedUser == null) {
            initializeUserByAuthToke();
        }

        return loggedUser;
    }

    public static AuthToken getAuthToken() {
        return authToken;
    }

    public static void setAuthToken(AuthToken authToken) {
        AuthSingleton.authToken = authToken;
    }
}
