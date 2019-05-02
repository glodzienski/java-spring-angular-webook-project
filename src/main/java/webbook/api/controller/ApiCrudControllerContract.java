package webbook.api.controller;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface ApiCrudControllerContract<Model> {
    Model store(@RequestBody @Valid Model model);

    @PutMapping("{code}")
    Model update(@PathVariable String code, @RequestBody @Valid Model model);

    @ResponseBody
    Model getByCode(String code);

    @ResponseBody
    Iterable<Model> list();

    @DeleteMapping("{code}")
    void destroy(@PathVariable String code);
}
