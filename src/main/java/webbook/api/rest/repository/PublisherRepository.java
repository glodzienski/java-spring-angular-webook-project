package webbook.api.rest.repository;

import org.springframework.stereotype.Repository;
import webbook.api.model.entity.Publisher;

@Repository
public interface PublisherRepository extends BaseRepository<Publisher, String> {
}
