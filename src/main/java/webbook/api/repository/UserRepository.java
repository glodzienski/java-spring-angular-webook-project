package webbook.api.repository;

import org.springframework.stereotype.Repository;
import webbook.api.entity.User;

@Repository
public interface UserRepository extends BaseRepository<User, String> {
    User findByCode(String code);
}
