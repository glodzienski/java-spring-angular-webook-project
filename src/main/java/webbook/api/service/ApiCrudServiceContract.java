package webbook.api.service;

interface ApiCrudServiceContract<Model> {
    Model store(Model model);

    Model update(Model model);

    Model getById(int id);

    Model getByToken(String token);

    Iterable<Model> list();

    Model destroy(Model model);
}
