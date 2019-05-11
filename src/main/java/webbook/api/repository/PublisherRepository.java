package webbook.api.repository;

import org.springframework.stereotype.Repository;
import webbook.api.model.Publisher;

@Repository
public interface PublisherRepository extends BaseRepository<Publisher, String> {
}
