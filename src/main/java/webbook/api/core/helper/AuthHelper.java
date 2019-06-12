package webbook.api.core.helper;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import webbook.api.model.entity.AuthToken;
import webbook.api.model.entity.User;

public class AuthHelper {
    public static User user() {
        return (User) AuthHelper.authHolder().getPrincipal();
    }

    public static AuthToken authToken() {
        return (AuthToken) AuthHelper.authHolder().getCredentials();
    }

    private static Authentication authHolder() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
