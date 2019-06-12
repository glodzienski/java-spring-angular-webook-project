package webbook.api.repository;

import org.springframework.stereotype.Repository;
import webbook.api.entity.Subscription;

@Repository
public interface SubscriptionRepository extends BaseRepository<Subscription, String> {
}
