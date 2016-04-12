package com.iba.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDetailsRepository extends CrudRepository<PersonalDetails, Long>  {

}
