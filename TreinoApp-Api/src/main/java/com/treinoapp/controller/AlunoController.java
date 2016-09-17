package com.treinoapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.treinoapp.model.Aluno;
import com.treinoapp.services.interfaces.AlunoService;

@RestController
@RequestMapping(value = "/api/v1/aluno")
public class AlunoController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AlunoService alunoService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> adicionar(@RequestBody Aluno aluno) {

		logger.debug("adicionar() Adicionando aluno com nome: " + aluno.getNome());
		alunoService.adicionar(aluno);
		return new ResponseEntity<String>("Aluno cadastrado com sucesso!", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<String> atualizar(@RequestBody Aluno aluno) {
		logger.debug("atualizar() Atualizar aluno com id: " + aluno.getId());
		alunoService.atualizar(aluno);
		return new ResponseEntity<String>("Aluno atualizado com sucesso!", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Aluno> buscar(@RequestParam Long id) {
		logger.debug("buscar() Buscar aluno com id: " + id);
		Aluno aluno = alunoService.buscarPorId(id);
		return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
	}

	@RequestMapping(path = "/busca-email", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Aluno> buscarPorParteEmail(@RequestParam String email) {
		logger.debug("buscarPorEmail() Buscar aluno por email: " + email);
		return alunoService.buscarPorParteEmail(email);
	}

	@RequestMapping(path = "/busca-nome", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Aluno> buscarPorNome(@RequestParam String nome) {
		logger.debug("buscarPorNome() Buscar por nome: " + nome);
		return alunoService.buscarPorNome(nome);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<String> remover(@RequestParam Long id) {
		logger.debug("remover() Remover aluno com id: " + id);
		alunoService.remover(id);
		return ResponseEntity.status(HttpStatus.OK).body("Aluno removido com sucesso!");
	}

}
