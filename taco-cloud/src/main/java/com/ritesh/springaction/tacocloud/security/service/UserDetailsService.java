package com.ritesh.springaction.tacocloud.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


// ? Spring automatically provides implementations for this service 
// ? One such implementation is InMemoryUserDetailsService
public interface UserDetailsService  extends org.springframework.security.core.userdetails.UserDetailsService{

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;


}
