package webbook.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import webbook.api.model.AuthToken;
import webbook.api.service.AuthService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthApiInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    AuthService authService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod hm = (HandlerMethod)handler;
        Method method = hm.getMethod();

        if(method.isAnnotationPresent(PublicRoute.class)) {
            return true;
        }

        String token = request.getHeader("token");
        if (token == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        AuthToken authToken = authService.getByToken(token);
        if (authToken == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        authService.registerAuthToken(authToken);

        return true;
    }
}
