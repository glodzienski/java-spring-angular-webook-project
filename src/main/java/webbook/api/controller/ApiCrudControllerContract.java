package webbook.api.controller;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface ApiCrudControllerContract<Model> {
    @PostMapping
    Model store(@RequestBody @Valid Model model);

    @PutMapping("{code}")
    Model update(@PathVariable String code, @RequestBody @Valid Model model);

    @GetMapping("{code}")
    @ResponseBody
    Model getByCode(String code);

    @GetMapping
    @ResponseBody
    Iterable<Model> list();

    @DeleteMapping("{code}")
    void destroy(@PathVariable String code);
}
