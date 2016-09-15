package com.treinoapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/treino")
public class TreinoCadastroController {
	
	
//	private TreinoService treinoService;
//	
//	
//	@RequestMapping(method = RequestMethod.POST)
//	public ResponseEntity<String> adicionar(@RequestBody Treino treino) {
//		treinoService.adicionar(treino);
//		return ResponseEntity.status(HttpStatus.OK).body("Treino cadastrado com sucesso!");
//	}
//	
//	@RequestMapping(method = RequestMethod.POST)
//	public ResponseEntity<String> atualizar(@RequestBody Treino treino) {
//		treinoService.atualizar(treino);
//		return ResponseEntity.status(HttpStatus.OK).body("Treino cadastrado com sucesso!");
//	}
//	
//	@RequestMapping(value = "/{idAluno}/{idTreino}", method = RequestMethod.GET)
//	@ResponseStatus(value = HttpStatus.OK)
//	public Treino buscar(@RequestParam Long idAluno, @RequestParam Long idTreino) {
//		
//		//buscar aluno
//		
//		return treinoService.buscarPorId(id);
//	}
//	
//	@RequestMapping(method = RequestMethod.DELETE)
//	public ResponseEntity<String> remover(@RequestParam Long id) {
//		treinoService.remover(id);
//		return ResponseEntity.status(HttpStatus.OK).body("Treino removido com sucesso!");
//	}


}
