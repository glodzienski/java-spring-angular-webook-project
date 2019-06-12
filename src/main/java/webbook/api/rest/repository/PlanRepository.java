package webbook.api.rest.repository;

import org.springframework.stereotype.Repository;
import webbook.api.model.entity.Plan;

@Repository
public interface PlanRepository extends BaseRepository<Plan, String> {
}
