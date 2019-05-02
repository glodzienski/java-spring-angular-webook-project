package webbook.api.repository;

import org.springframework.stereotype.Repository;
import webbook.api.entity.Plan;

@Repository
public interface PlanRepository extends BaseRepository<Plan, String> {
    Plan findByCode(String code);
}
