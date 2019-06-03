package webbook.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import webbook.api.helper.AuthHelper;
import webbook.api.model.Address;
import webbook.api.service.AddressService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/address")
public class AddressController implements ApiCrudControllerContract<Address> {

    private AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @Override
    public Address store(@Valid Address address) {
        address.setUser(AuthHelper.user());

        return service.store(address);
    }

    @Override
    public Address update(String code, Address address) {
        throw new ResponseStatusException(
                HttpStatus.METHOD_NOT_ALLOWED,
                "Não é possível editar endereços. Somente criar e deletar."
        );
    }

    @Override
    public Address getByCode(@PathVariable String code) {
        Address address = service.getByCode(code);
        if (address == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado.");
        }

        return address;
    }

    @Override
    public Iterable<Address> list() {
        return service.list();
    }

    @Override
    public void destroy(String code) {
        Address address = service.getByCode(code);
        if (address == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado.");
        }

        service.destroy(address);
    }
}
