package webbook.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import webbook.api.dto.AuthLoginDTO;
import webbook.api.entity.AuthToken;
import webbook.api.entity.User;
import webbook.api.repository.AuthTokenRepository;
import webbook.api.helper.UUIDGeneratorHelper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class AuthService {
    @Autowired
    private AuthTokenRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource(name = "authenticationManager")
    private AuthenticationManager authManager;

    public AuthToken getByTokenActive(String token) {
        AuthToken authToken = repository.findByToken(token);
        if (authToken == null || !authToken.getActive()) {
            return null;
        }
        return authToken;
    }

    public void registerAuthInfos(HttpServletRequest request, AuthToken authToken) {
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(
                authToken.getUser(), authToken
        );

        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(authReq);

        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", sc);
    }

    public Boolean validatePassword(AuthLoginDTO authLoginDTO, User user) {
        return passwordEncoder.matches(authLoginDTO.password, user.getPassword());
    }

    public AuthToken getActiveAuthTokenOfUser(User user) {
        return repository.findByUserAndActive(user, true);
    }

    public void invalidateAuthToken(AuthToken authToken) {
        authToken.setActive(false);
        repository.save(authToken);
    }

    public AuthToken createAuthToken(User user) {
        AuthToken authToken = new AuthToken();
        authToken.setUser(user);
        authToken.setActive(true);
        authToken.setToken(UUIDGeneratorHelper.get());

        return repository.save(authToken);
    }
}
