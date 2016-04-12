package com.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> 
{	
	@Query("select a.role from Role a, User b where b.userName=?1 and a.roleId=b.role")
    public List<String> findRoleByUserName(String username);
		
}