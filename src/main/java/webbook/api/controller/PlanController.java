package webbook.api.controller;

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

    private PlanService service;

    public PlanController(PlanService service) {
        this.service = service;
    }

    @Override
    public Plan store(@Valid Plan user) {
        return service.store(user);
    }

    @Override
    public Plan update(String code, @Valid Plan user) {
        Plan currentPlan = service.getByCode(code);
        if (currentPlan == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plano não encontrado.");
        }

        return service.update(currentPlan, user);
    }

    @Override
    public Plan getByCode(@PathVariable String code) {
        return service.getByCode(code);
    }

    @Override
    public Iterable<Plan> list() {
        return service.list();
    }

    @Override
    public void destroy(String code) {
        Plan user = service.getByCode(code);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plano não encontrado.");
        }

        service.destroy(user);
    }
}
