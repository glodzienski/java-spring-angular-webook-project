package webbook.api.repository;

import org.springframework.stereotype.Repository;
import webbook.api.model.Plan;

@Repository
public interface PlanRepository extends BaseRepository<Plan, String> {
}
