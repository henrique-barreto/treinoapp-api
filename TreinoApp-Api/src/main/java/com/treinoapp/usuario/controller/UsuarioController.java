package com.treinoapp.usuario.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.treinoapp.usuario.model.Usuario;
import com.treinoapp.usuario.service.interfaces.UsuarioService;

@RestController
@RequestMapping(value = "/api/v1/usuarios")
public class UsuarioController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.GET, params = "nome")
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> buscarPorNome(@RequestParam(required = true) String nome) {
		logger.debug("buscar() Buscar usuario por nome: " + nome);
		return usuarioService.buscarPorNome(nome);
	}

	@RequestMapping(method = RequestMethod.GET, params = "email")
	@ResponseStatus(HttpStatus.OK)
	public Usuario buscarPorEmail(@RequestParam(required = true) String email) {
		logger.debug("buscar() Buscar usuario por parte de email: " + email);
		return usuarioService.buscarPorEmail(email);
	}

	@RequestMapping(method = RequestMethod.GET, params = "parteEmail")
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> buscarPorEmailContendo(@RequestParam(required = true) String parteEmail) {
		logger.debug("buscar() Buscar usuario por parte de email: " + parteEmail);
		return usuarioService.buscarPorEmailContendo(parteEmail);
	}

}
