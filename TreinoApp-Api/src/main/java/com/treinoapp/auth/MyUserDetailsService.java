package com.treinoapp.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

//	@Autowired
//	private UsuarioRN usuarioRN;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		System.out.println("MyUserDetailsService: procurando por: " + username);
		
		
		try {
			if (username == null || username.isEmpty()) {
				throw new IllegalArgumentException("username passado pro MyUserDetailsService null ou vazio");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ALUNO"));
		return new User("user", "password", authorities);
	}

}