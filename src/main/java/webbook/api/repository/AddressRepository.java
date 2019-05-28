package webbook.api.repository;

import org.springframework.stereotype.Repository;
import webbook.api.model.Address;
import webbook.api.model.User;

import java.util.ArrayList;

@Repository
public interface AddressRepository extends BaseRepository<Address, String> {
    ArrayList<Address> findAllByUser(User user);
}
