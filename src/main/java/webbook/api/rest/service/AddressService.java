package webbook.api.rest.service;

import org.jetbrains.annotations.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import webbook.api.core.helper.AuthHelper;
import webbook.api.model.entity.Address;
import webbook.api.rest.repository.AddressRepository;
import webbook.api.core.helper.UUIDGeneratorHelper;

@Service
public class AddressService implements ApiCrudServiceContract<Address> {
    @Autowired
    private AddressRepository repository;

    @Contract(pure = true)
    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public Address store(Address address) {
        address.setCode(UUIDGeneratorHelper.get());

        return repository.save(address);
    }

    @Override
    public Address update(Address currentAddress, Address requestAddress) {
        throw new ResponseStatusException(
                HttpStatus.METHOD_NOT_ALLOWED,
                "Não é possível editar endereços. Somente criar e deletar."
        );
    }

    @Override
    public Address getById(int id) {
        return null;
    }

    @Override
    public Address getByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public Iterable<Address> list() {
        return repository.findAllByUser(AuthHelper.user());
    }

    @Override
    public void destroy(Address address) {
        repository.delete(address);
    }
}
