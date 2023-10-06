package webbook.api.rest.repository;

import org.springframework.stereotype.Repository;
import webbook.api.model.entity.User;

@Repository
public interface UserRepository extends BaseRepository<User, String> {
    User findByEmail(String email);

    User findByCpf(String cpf);
}
