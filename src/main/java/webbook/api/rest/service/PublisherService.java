package webbook.api.rest.service;

import org.jetbrains.annotations.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webbook.api.model.entity.Publisher;
import webbook.api.rest.repository.PublisherRepository;
import webbook.api.core.helper.UUIDGeneratorHelper;

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
        publisher.setCode(UUIDGeneratorHelper.get());

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
