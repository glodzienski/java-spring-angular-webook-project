package webbook.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webbook.api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByCode(String code);
}
