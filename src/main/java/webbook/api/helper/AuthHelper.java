package webbook.api.helper;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import webbook.api.entity.AuthToken;
import webbook.api.entity.User;

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
