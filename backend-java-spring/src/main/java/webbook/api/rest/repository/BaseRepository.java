package webbook.api.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<Model, ID> extends JpaRepository<Model, ID> {
    Model findByCode(String code);
}
