package com.treinoapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.treinoapp.model.Aluno;
import com.treinoapp.model.AvaliacaoFisica;
import com.treinoapp.model.Professor;
import com.treinoapp.services.interfaces.AlunoService;
import com.treinoapp.services.interfaces.AvaliacaoService;
import com.treinoapp.services.interfaces.ProfessorService;

@RestController
@RequestMapping(value = "/api/v1/avaliacao")
public class AvaliacaoController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AvaliacaoService avaliacaoService;

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private ProfessorService professorService;

	@RequestMapping(path = "/aluno/{idAluno}/professor/{idProfessor}", method = RequestMethod.POST)
	public ResponseEntity<String> adicionar(@PathVariable Long idAluno, @PathVariable Long idProfessor,
			@RequestBody AvaliacaoFisica avaliacao) {

		logger.debug("adicionar() cadastro de avaliacao fisica - Aluno: " + idAluno + " professor: " + idProfessor);

		Aluno aluno = alunoService.buscarPorId(idAluno);
		Professor professor = professorService.buscarPorId(idProfessor);
		avaliacao.setAluno(aluno);
		avaliacao.setProfessor(professor);
		
		logger.debug("\n" + avaliacao.getAnamnese().toString());
		logger.debug("\n" + avaliacao.getPerimetria().toString());
		logger.debug("\n" + avaliacao.getDobras().toString());
		
		avaliacaoService.adicionar(avaliacao);
		return new ResponseEntity<String>("Treino avaliacao com sucesso!", HttpStatus.OK);
	}

//	@RequestMapping(method = RequestMethod.PUT)
//	public ResponseEntity<String> atualizar(@RequestBody Treino treino) {
//		logger.debug("atualizar() cadastro de treino");
//		avaliacaoService.atualizar(treino);
//		return new ResponseEntity<String>("Treino atualizado com sucesso!", HttpStatus.OK);
//	}
//
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<Treino> buscar(@RequestParam Long id) {
//		logger.debug("buscar() Buscando treino por id: " + id);
//		Treino treino = avaliacaoService.buscarPorId(id);
//		return new ResponseEntity<Treino>(treino, HttpStatus.OK);
//	}
//
//	@RequestMapping(path = "/ativo/aluno/{id}", method = RequestMethod.GET)
//	public Treino buscarTreinoAtivo(@PathVariable Long id) {
//		logger.debug("buscarTreinoAtivo() Buscando treino ativo do aluno: " + id);
//		return avaliacaoService.buscarTreinoAtivo(id);
//	}
//
//	@RequestMapping(path = "/todos/aluno/{id}", method = RequestMethod.GET)
//	public List<Treino> listarTreinos(@PathVariable Long id) {
//		logger.debug("listarTreinos() Listando todos os treinos do aluno: " + id);
//		return avaliacaoService.listarTreinos(id);
//	}
//
//	@RequestMapping(method = RequestMethod.DELETE)
//	public ResponseEntity<String> remover(@PathVariable Long id) {
//		logger.debug("remover() Removendo treino: " + id);
//		avaliacaoService.remover(id);
//		return ResponseEntity.status(HttpStatus.OK).body("Treino removido com sucesso!");
//	}

}
