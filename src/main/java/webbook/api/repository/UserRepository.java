package webbook.api.repository;

import org.springframework.stereotype.Repository;
import webbook.api.model.User;

@Repository
public interface UserRepository extends BaseRepository<User, String> {
    User findByEmail(String email);
}
