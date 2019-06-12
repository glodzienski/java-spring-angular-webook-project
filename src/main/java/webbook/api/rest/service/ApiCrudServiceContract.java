package webbook.api.rest.service;

interface ApiCrudServiceContract<Model> {
    Model store(Model model);

    Model update(Model currentModel, Model requestModel);

    Model getById(int id);

    Model getByCode(String code);

    Iterable<Model> list();

    void destroy(Model model);
}
