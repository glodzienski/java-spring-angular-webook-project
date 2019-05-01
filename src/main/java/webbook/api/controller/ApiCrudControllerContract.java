package webbook.api.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

public interface ApiCrudControllerContract<Model> {
    Model store(@RequestBody @Valid Model model);

    Model update(@RequestBody @Valid Model model);

    @ResponseBody
    Model getById(int id);

    @ResponseBody
    Model getByCode(String code);

    @ResponseBody
    Iterable<Model> list();

    Model destroy(@RequestBody Model model);
}
