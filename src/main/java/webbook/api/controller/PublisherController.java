package webbook.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import webbook.api.model.Publisher;
import webbook.api.service.PublisherService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController implements ApiCrudControllerContract<Publisher> {

    private PublisherService service;

    public PublisherController(PublisherService service) {
        this.service = service;
    }

    @Override
    public Publisher store(@Valid Publisher publisher) {
        return service.store(publisher);
    }

    @Override
    public Publisher update(String code, Publisher publisher) {
        Publisher currentPublisher = service.getByCode(code);
        if (currentPublisher == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Editora não encontrada.");
        }

        return service.update(currentPublisher, publisher);
    }

    @Override
    public Publisher getByCode(@PathVariable String code) {
        return service.getByCode(code);
    }

    @Override
    public Iterable<Publisher> list() {
        return service.list();
    }

    @Override
    public void destroy(String code) {
        Publisher publisher = service.getByCode(code);
        if (publisher == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Editora não encontrada.");
        }

        service.destroy(publisher);
    }
}
