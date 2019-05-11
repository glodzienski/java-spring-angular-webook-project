package webbook.api.repository;

import org.springframework.stereotype.Repository;
import webbook.api.model.Address;

@Repository
public interface AddressRepository extends BaseRepository<Address, String> {
}
