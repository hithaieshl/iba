package com.iba.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.lang.String;
import com.iba.domain.RegisteredEmail;
import java.util.List;

@Repository
public interface RegisteredEmailsRepository extends CrudRepository<RegisteredEmail, Long>{

	List<RegisteredEmail> findByEmail(String email);
	
	
	
	
	
}
