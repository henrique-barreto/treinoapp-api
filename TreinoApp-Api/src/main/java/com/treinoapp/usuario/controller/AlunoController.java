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
import com.treinoapp.usuario.model.Aluno;
import com.treinoapp.usuario.service.interfaces.AlunoService;
import com.treinoapp.usuario.service.interfaces.UsuarioService;

@RestController
@RequestMapping(value = "/api/v1/alunos")
public class AlunoController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	 @Autowired
	 private AlunoService alunoService;

	@Autowired
	private UsuarioService usuarioService;

	// |====================|
	// |== Usuario service =|
	// |====================|
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void salvar(@RequestBody UsuarioDto dto) {
		logger.debug("adicionar() Adicionando aluno com nome: " + dto.getNome());
		usuarioService.salvar(new Aluno(dto));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void atualizar(@PathVariable(required = true) Long id, @RequestBody UsuarioDto dto) {
		logger.debug("atualizar() Atualizando aluno com nome: " + dto.getNome());
		usuarioService.atualizar(id, new Aluno(dto));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void remover(@PathVariable(required = true) Long id) {
		logger.debug("remover() Removendo aluno com id: " + id);
		usuarioService.remover(id);
	}

	// |====================|
	// |== Aluno service ===|
	// |====================|
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Aluno buscar(@PathVariable(required = true) Long id) {
		logger.debug("buscar() Buscar aluno com id: " + id);
		return alunoService.buscarPorId(id);
	}

	@RequestMapping(method = RequestMethod.GET, params = "nome")
	@ResponseStatus(HttpStatus.OK)
	public List<Aluno> buscarPorNome(@RequestParam(required = true) String nome) {
		logger.debug("buscar() Buscar aluno por nome: " + nome);
		return alunoService.buscarPorNome(nome);
	}

	@RequestMapping(method = RequestMethod.GET, params = "parteEmail")
	@ResponseStatus(HttpStatus.OK)
	public List<Aluno> buscarPorEmailContendo(@RequestParam(required = true) String parteEmail) {
		logger.debug("buscar() Buscar alunos por parte de email: " + parteEmail);
		return alunoService.buscarPorEmailContendo(parteEmail);
	}
}
