package webbook.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webbook.api.model.AuthToken;
import webbook.api.model.User;

@Repository
public interface AuthTokenRepository extends JpaRepository<AuthToken, String> {
    AuthToken findByToken(String token);

    AuthToken findByUserAndActive(User user, Boolean active);
}
