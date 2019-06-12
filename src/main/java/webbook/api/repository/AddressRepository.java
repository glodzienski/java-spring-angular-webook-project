package webbook.api.repository;

import org.springframework.stereotype.Repository;
import webbook.api.entity.Address;
import webbook.api.entity.User;

import java.util.ArrayList;

@Repository
public interface AddressRepository extends BaseRepository<Address, String> {
    ArrayList<Address> findAllByUser(User user);
}
