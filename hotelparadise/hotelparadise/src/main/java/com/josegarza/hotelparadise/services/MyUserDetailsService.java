package com.josegarza.hotelparadise.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.josegarza.hotelparadise.models.User;
import com.josegarza.hotelparadise.models.UserPrincipal;
import com.josegarza.hotelparadise.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findUserByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
		return new UserPrincipal(user);
	}

}
