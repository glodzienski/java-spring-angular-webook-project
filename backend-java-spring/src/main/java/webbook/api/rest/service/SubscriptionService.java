package webbook.api.rest.service;

import org.jetbrains.annotations.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webbook.api.model.entity.Subscription;
import webbook.api.rest.repository.SubscriptionRepository;
import webbook.api.core.helper.UUIDGeneratorHelper;

import java.util.Date;

@Service
public class SubscriptionService implements ApiCrudServiceContract<Subscription> {
    @Autowired
    private SubscriptionRepository repository;

    @Contract(pure = true)
    public SubscriptionService(SubscriptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Subscription store(Subscription subscription) {
        subscription.setCode(UUIDGeneratorHelper.get());
        subscription.setHiringDate(new Date());
        subscription.setEmailContact(subscription.getUser().getEmail());

        return repository.save(subscription);
    }

    @Override
    public Subscription update(Subscription currentSubscription, Subscription requestSubscription) {


        return repository.save(currentSubscription);
    }

    @Override
    public Subscription getById(int id) {
        return null;
    }

    @Override
    public Subscription getByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public Iterable<Subscription> list() {
        return repository.findAll();
    }

    @Override
    public void destroy(Subscription subscription) {
        repository.delete(subscription);
    }
}
