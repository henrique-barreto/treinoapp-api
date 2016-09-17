package com.treinoapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.treinoapp.model.Usuario;
import com.treinoapp.services.interfaces.UsuarioService;

@RestController
@RequestMapping(value = "/api/v1/usuario")
public class UsuarioController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
		logger.debug("buscar() Buscando usuario por id: " + id);
		Usuario usuario = usuarioService.buscarPorId(id);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public Usuario buscarPorEmail(@RequestParam String email) {
		logger.debug("buscarPorEmail() Buscando usuario por email: " + email);
		return usuarioService.buscarPorEmail(email);
	}

	@RequestMapping(path = "/busca-nome", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Usuario> BuscarPorNome(@RequestParam String nome) {
		logger.debug("BuscarPorNome() Buscando usuario por nome: " + nome);
		return usuarioService.buscarPorNome(nome);
	}

	@RequestMapping(path = "/busca-email", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Usuario> buscarPorParteEmail(@RequestParam String email) {
		logger.debug("buscarPorParteEmail() Buscando usuario por parte email: " + email);
		return usuarioService.buscarPorParteEmail(email);
	}

}
