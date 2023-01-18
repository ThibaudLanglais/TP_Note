package com.ensim.tpnote.tpnote;

import com.ensim.tpnote.tpnote.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
