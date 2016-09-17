package com.treinoapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.treinoapp.model.Professor;
import com.treinoapp.services.interfaces.ProfessorService;

@RestController
@RequestMapping(value = "/api/v1/professor")
public class ProfessorController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProfessorService professorService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> adicionar(@RequestBody Professor professor) {
		logger.debug("adicionar() cadastro de professor...");
		professorService.adicionar(professor);
		return new ResponseEntity<String>("Professor cadastrado com sucesso!", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<String> atualizar(@RequestBody Professor professor) {
		logger.debug("atualizar() cadastro de professor...");
		professorService.atualizar(professor);
		return new ResponseEntity<String>("Professor atualizado com sucesso!", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Professor> buscar(@RequestParam Long id) {
		logger.debug("buscar() cadastro de professor por id...");
		Professor professor = professorService.buscarPorId(id);
		return new ResponseEntity<Professor>(professor, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ALUNO')")
	@RequestMapping(path = "/busca-nome", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Professor> buscarPorEmail(@RequestParam String nome) {
		logger.debug("buscarPorEmail() cadastro de professor por nome...");
		return professorService.buscarPorNome(nome);
	}

	@RequestMapping(path = "/busca-email", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Professor> buscarPorParteEmail(@RequestParam String email) {
		logger.debug("buscarPorParteEmail() cadastro de professor por parte de email...");
		return professorService.buscarPorParteEmail(email);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<String> remover(@RequestParam Long id) {
		logger.debug("remover() remover cadastro de professor...");
		professorService.remover(id);
		return ResponseEntity.status(HttpStatus.OK).body("Professor removido com sucesso!");
	}

}
