package webbook.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import webbook.api.entity.Plan;
import webbook.api.service.PlanService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/plan")
public class PlanController implements ApiCrudControllerContract<Plan> {

    @Autowired
    private PlanService service;

    @Override
    public Plan store(@Valid Plan plan) {
        return service.store(plan);
    }

    @Override
    public Plan update(String code, @Valid Plan plan) {
        Plan currentPlan = service.getByCode(code);
        if (currentPlan == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plano não encontrado.");
        }

        return service.update(currentPlan, plan);
    }

    @Override
    public Plan getByCode(@PathVariable String code) {
        Plan plan = service.getByCode(code);
        if (plan == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plano não encontrado.");
        }

        return plan;
    }

    @Override
    public Iterable<Plan> list() {
        return service.list();
    }

    @Override
    public void destroy(String code) {
        Plan plan = service.getByCode(code);
        if (plan == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plano não encontrado.");
        }

        service.destroy(plan);
    }
}
