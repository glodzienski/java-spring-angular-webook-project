package webbook.api.service;

import org.jetbrains.annotations.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import webbook.api.entity.Publisher;
import webbook.api.repository.PublisherRepository;
import webbook.api.util.UUIDGeneratorUtil;

@Service
public class PublisherService implements ApiCrudServiceContract<Publisher> {
    @Autowired
    private PublisherRepository repository;

    @Contract(pure = true)
    public PublisherService(PublisherRepository repository) {
        this.repository = repository;
    }

    @Override
    public Publisher store(Publisher publisher) {
        publisher.setCode(UUIDGeneratorUtil.get());

        return repository.save(publisher);
    }

    @Override
    public Publisher update(Publisher currentPublisher, Publisher requestPublisher) {
        currentPublisher.setFoundationDate(requestPublisher.getFoundationDate());
        currentPublisher.setName(requestPublisher.getName());
        currentPublisher.setEmailContact(requestPublisher.getEmailContact());

        return repository.save(currentPublisher);
    }

    @Override
    public Publisher getById(int id) {
        return null;
    }

    @Override
    public Publisher getByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public Iterable<Publisher> list() {
        return repository.findAll();
    }

    @Override
    public void destroy(Publisher publisher) {
        repository.delete(publisher);
    }
}
