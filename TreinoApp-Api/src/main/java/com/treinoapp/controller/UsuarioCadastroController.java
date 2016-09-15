package com.treinoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.treinoapp.model.Usuario;
import com.treinoapp.services.UsuarioService;

@RestController
@RequestMapping(value = "/api/v1/usuario")
public class UsuarioCadastroController {

	@Autowired
	private UsuarioService usuarioService;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> adicionar(@RequestBody Usuario usuario) {
		usuarioService.adicionar(usuario);
		return new ResponseEntity<String>("Usuario cadastrado com sucesso!", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<String> atualizar(@RequestBody Usuario usuario) {
		System.out.println("Nome: " + usuario.getNome());
		usuarioService.atualizar(usuario);
		return new ResponseEntity<String>("Usuario atualizado com sucesso!", HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ALUNO')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Usuario> buscar(@RequestParam Long id) {
		System.out.println("GET: " + id);
		Usuario usuario = usuarioService.buscarPorId(id);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ALUNO')")
	@RequestMapping(path = "/busca-nome", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Usuario> buscarPorEmail(@RequestParam String nome) {
		
		System.out.println("Chamando metodo seguro!");
		return usuarioService.buscarPorNome(nome);
	}
		
	@RequestMapping(path = "/busca-email", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Usuario> buscarPorParteEmail(@RequestParam String email) {
		return usuarioService.buscarPorParteEmail(email);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<String> remover(@RequestParam Long id) {
		usuarioService.remover(id);
		return ResponseEntity.status(HttpStatus.OK).body("Usuario removido com sucesso!");
	}

}
