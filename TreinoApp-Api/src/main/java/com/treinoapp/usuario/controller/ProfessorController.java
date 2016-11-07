package com.treinoapp.usuario.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.treinoapp.usuario.dto.UsuarioDto;
import com.treinoapp.usuario.model.Professor;
import com.treinoapp.usuario.service.interfaces.ProfessorService;
import com.treinoapp.usuario.service.interfaces.UsuarioService;

@RestController
@RequestMapping(value = "/api/v1/professores")
public class ProfessorController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	 @Autowired
	 private ProfessorService professorService;

	@Autowired
	private UsuarioService usuarioService;

	// |====================|
	// |== Usuario service =|
	// |====================|
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody UsuarioDto dto) {
		logger.debug("adicionar() Adicionando professor com nome: " + dto.getNome());
		usuarioService.salvar(new Professor(dto));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void atualizar(@PathVariable(required = true) Long id, @RequestBody UsuarioDto dto) {
		logger.debug("atualizar() Atualizando professor com nome: " + dto.getNome());
		usuarioService.atualizar(id, new Professor(dto));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void remover(@PathVariable(required = true) Long id) {
		logger.debug("remover() Removendo professor com id: " + id);
		usuarioService.remover(id);
	}

	// |========================|
	// |== Professor service ===|
	// |========================|
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Professor buscar(@PathVariable(required = true) Long id) {
		logger.debug("buscar() Buscar professor com id: " + id);
		return professorService.buscarPorId(id);
	}

	@RequestMapping(method = RequestMethod.GET, params = "nome")
	@ResponseStatus(HttpStatus.OK)
	public List<Professor> buscarPorNome(@RequestParam(required = true) String nome) {
		logger.debug("buscar() Buscar professor por nome: " + nome);
		return professorService.buscarPorNome(nome);
	}

	@RequestMapping(method = RequestMethod.GET, params = "parteEmail")
	@ResponseStatus(HttpStatus.OK)
	public List<Professor> buscarPorEmailContendo(@RequestParam(required = true) String parteEmail) {
		logger.debug("buscar() Buscar professors por parte de email: " + parteEmail);
		return professorService.buscarPorEmailContendo(parteEmail);
	}
}
