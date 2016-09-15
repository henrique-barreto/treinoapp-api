package com.treinoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.treinoapp.model.Usuario;
import com.treinoapp.services.UsuarioService;

@RestController
@RequestMapping(value = "/api/v1/test")
public class TestController {

	@Autowired
	private UsuarioService usuarioService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Usuario> buscar(@RequestParam Long id) {
		System.out.println("GET: " + id);
		Usuario usuario = usuarioService.buscarPorId(id);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
}
