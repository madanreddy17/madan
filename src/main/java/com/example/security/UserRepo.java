package com.example.security;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<OurUser, Integer>{

	
	
	@Query("select u from OurUser u where u.name=?1")
	public abstract OurUser getUserNmae(String username);
	
	@Query("select r from OurUser u join u.roles r where u.name=?1")
	public abstract List<Role> getRoles(String username );
}
