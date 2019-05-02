package webbook.api.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

public interface ApiCrudControllerContract<Model> {
    Model store(@RequestBody @Valid Model model);

    @PutMapping("{code}")
    Model update(@PathVariable String code, @RequestBody @Valid Model model);

    @ResponseBody
    Model getByCode(String code);

    @ResponseBody
    Iterable<Model> list();

    Model destroy(@RequestBody Model model);
}
