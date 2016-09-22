package com.treinoapp.auth;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.treinoapp.model.Permissao;
import com.treinoapp.model.Usuario;
import com.treinoapp.services.interfaces.UsuarioService;

@Component
public class MyUserDetailsService implements UserDetailsService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {
			logger.info("loadUserByUsername()  Dormindo...");
			Thread.sleep(5000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		logger.debug("loadUserByUsername()  procurando por: " + username);

		Usuario usuario = usuarioService.buscarPorEmail(username);

		if (usuario == null) {
			logger.debug("loadUserByUsername() Usuario com username: " + username + " nao encontrado.");
			throw new UsernameNotFoundException("User '" + username + ": UsernameNotFoundException");
		}

		// get authorities
		List<GrantedAuthority> authorities = loadUserAuthorities(usuario);

		// no authorities
		if (authorities.size() == 0) {
			throw new UsernameNotFoundException(
					"User '" + username + "' has no authorities and will be treated as 'not found'");
		}

		return createUserDetails(usuario, authorities);
	}

	private List<GrantedAuthority> loadUserAuthorities(Usuario usuario) {

		Permissao permissao = usuario.getPermissao();

		List<GrantedAuthority> authorities = new ArrayList<>();
		if (permissao == Permissao.ROLE_ALUNO) {
			logger.debug("loadUserAuthorities() Permissoes do usuario: ROLE_ALUNO");
			authorities.add(new SimpleGrantedAuthority("ROLE_ALUNO"));
		} else if (permissao == Permissao.ROLE_ADMIN) {
			logger.debug("loadUserAuthorities() Permissoes do usuario: ROLE_ADMIN");
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		} else if (permissao == Permissao.ROLE_PROFESSOR) {
			logger.debug("loadUserAuthorities() Permissoes do usuario: ROLE_PROFESSOR");
			authorities.add(new SimpleGrantedAuthority("ROLE_PROFESSOR"));
		}
		return authorities;

	}

	private UserDetails createUserDetails(Usuario usuario, List<GrantedAuthority> authorities) {
		return new User(usuario.getEmail(), usuario.getSenha(), true, true, true, true, authorities);
	}

}