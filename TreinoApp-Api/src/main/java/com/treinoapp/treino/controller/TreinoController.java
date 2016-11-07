//package com.treinoapp.treino.controller;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.treinoapp.services.interfaces.TreinoService;
//import com.treinoapp.treino.model.Treino;
//import com.treinoapp.usuario.model.Aluno;
//import com.treinoapp.usuario.model.Professor;
//import com.treinoapp.usuario.service.interfaces.AlunoService;
//import com.treinoapp.usuario.service.interfaces.ProfessorService;
//
//@RestController
//@RequestMapping(value = "/api/v1/treino")
//public class TreinoController {
//
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	private TreinoService treinoService;
//
//	@Autowired
//	private AlunoService alunoService;
//
//	@Autowired
//	private ProfessorService professorService;
//
//	@RequestMapping(path = "/aluno/{idAluno}/professor/{idProfessor}", method = RequestMethod.POST)
//	public ResponseEntity<String> adicionar(@PathVariable Long idAluno, @PathVariable Long idProfessor,
//			@RequestBody Treino treino) {
//
//		logger.debug("adicionar() cadastro de treino - Aluno: " + idAluno + " professor: " + idProfessor);
//
//		Aluno aluno = alunoService.buscarPorId(idAluno);
//		Professor professor = professorService.buscarPorId(idProfessor);
//		treino.setAluno(aluno);
//		treino.setProfessor(professor);
//		treinoService.adicionar(treino);
//		return new ResponseEntity<String>("Treino cadastrado com sucesso!", HttpStatus.OK);
//	}
//
//	@RequestMapping(method = RequestMethod.PUT)
//	public ResponseEntity<String> atualizar(@RequestBody Treino treino) {
//		logger.debug("atualizar() cadastro de treino");
//		treinoService.atualizar(treino);
//		return new ResponseEntity<String>("Treino atualizado com sucesso!", HttpStatus.OK);
//	}
//
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<Treino> buscar(@RequestParam Long id) {
//		logger.debug("buscar() Buscando treino por id: " + id);
//		Treino treino = treinoService.buscarPorId(id);
//		return new ResponseEntity<Treino>(treino, HttpStatus.OK);
//	}
//
//	@RequestMapping(path = "/ativo/aluno/{id}", method = RequestMethod.GET)
//	public Treino buscarTreinoAtivo(@PathVariable Long id) {
//		logger.debug("buscarTreinoAtivo() Buscando treino ativo do aluno: " + id);
//		return treinoService.buscarTreinoAtivo(id);
//	}
//
//	@RequestMapping(path = "/todos/aluno/{id}", method = RequestMethod.GET)
//	public List<Treino> listarTreinos(@PathVariable Long id) {
//		logger.debug("listarTreinos() Listando todos os treinos do aluno: " + id);
//		return treinoService.listarTreinos(id);
//	}
//
//	@RequestMapping(method = RequestMethod.DELETE)
//	public ResponseEntity<String> remover(@PathVariable Long id) {
//		logger.debug("remover() Removendo treino: " + id);
//		treinoService.remover(id);
//		return ResponseEntity.status(HttpStatus.OK).body("Treino removido com sucesso!");
//	}
//
//}
