package com.treinoapp.auth.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.treinoapp.usuario.dao.UsuarioRepository;
import com.treinoapp.usuario.model.Usuario;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UsuarioRepository usuarioRepository;

	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public Usuario pegarUsuarioLogado(Principal principal) {

		if (principal == null) {
			logger.debug("pegarUsuarioLogado() pegarUsuarioLogado principal.getName() null");
			return null;
		}

		logger.debug("pegarUsuarioLogado() pegarUsuarioLogado com email: " + principal.getName());
		Usuario usuario = usuarioRepository.findByEmail(principal.getName());

		if (usuario == null) {
			logger.debug("pegarUsuarioLogado() Nao achou usuario com email: " + principal.getName());
		}

		return usuario;
	}

}
