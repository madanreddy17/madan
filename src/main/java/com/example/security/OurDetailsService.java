package com.example.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
//hi this is for my information
//hello this is for your information
public class OurDetailsService implements UserDetailsService {

	@Autowired
        private	UserRepo userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    log.info("username::"+username);
	    OurUser ouruser=userrepo.getUserNmae(username);
	    if(ouruser!=null) {
			  log.info("User Details madan::"+ ouruser.getName()+"::"+ouruser.getPassword()+ouruser.getRoles());
			}
	List<Role> roles=userrepo.getRoles(username);
	log.info("Role Objects::"+roles);
    String[] strroles=new String[roles.size()];
	for(int i=0;i<roles.size();i++) {
		strroles[i]=	roles.get(i).getName();
	}
	log.info("Role strings::"+strroles);
	UserDetails ud = User.builder().username(ouruser.getName()).password("{noop}"+ouruser.getPassword())
			.roles(strroles)
			.build();
	return ud;
	}

}
