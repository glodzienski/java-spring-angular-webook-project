package webbook.api.service;

import javassist.NotFoundException;

interface ApiCrudServiceContract<Model> {
    Model store(Model model);

    Model update(Model model) throws NotFoundException;

    Model getById(int id);

    Model getByCode(String code);

    Iterable<Model> list();

    Model destroy(Model model);
}
