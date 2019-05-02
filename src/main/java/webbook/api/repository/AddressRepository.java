package webbook.api.repository;

import org.springframework.stereotype.Repository;
import webbook.api.entity.Address;

@Repository
public interface AddressRepository extends BaseRepository<Address, String> {
    Address findByCode(String code);
}
