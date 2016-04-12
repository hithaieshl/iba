package com.iba.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankDetailsRepository extends CrudRepository<BankDetails, Long>{

}
