package webbook.api.service;

import org.jetbrains.annotations.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webbook.api.model.Subscription;
import webbook.api.repository.SubscriptionRepository;
import webbook.api.util.UUIDGeneratorUtil;

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
        subscription.setCode(UUIDGeneratorUtil.get());
        subscription.setHiringDate(new Date());
        // TODO falta adicionar o email do usuário, pegando do objeto usuário do subscription

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
