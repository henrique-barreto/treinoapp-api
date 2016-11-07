//package com.treinoapp.treino.service;
//
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.treinoapp.dao.interfaces.TreinoDAO;
//import com.treinoapp.services.interfaces.TreinoService;
//import com.treinoapp.treino.model.Treino;
//
//@Service
//@Transactional
//public class TreinoServiceImpl {
//
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	private TreinoDAO dao;
//
//	public Treino adicionar(Treino treino) {
//		logger.debug("adicionar() Adicionando treino");
//		return dao.adicionar(treino);
//	}
//
//	public Treino atualizar(Treino treino) {
//		logger.debug("atualizar() Atualizando treino");
//		return dao.atualizar(treino);
//	}
//
//	public void remover(Long id) {
//		logger.debug("remover() Removendo treino: " + id);
//		dao.remover(id);
//	}
//
//	public Treino buscarPorId(Long id) {
//		logger.debug("buscarPorId() Buscando treino por id: " + id);
//		return dao.buscarPorId(id);
//	}
//
//	public Treino buscarTreinoAtivo(Long idAluno) {
//		logger.debug("buscarTreinoAtivo() Buscando treino ativo do aluno: " + idAluno);
//		return dao.buscarTreinoAtivo(idAluno);
//	}
//
//	public List<Treino> listarTreinos(Long idAluno) {
//		logger.debug("listarTreinos() Listando treinos do aluno: " + idAluno);
//		return dao.listarTreinos(idAluno);
//	}
//
//	public List<Treino> listarTreinosDoProfessor(Long idProfessor) {
//		logger.debug("listarTreinos() Listando treinos do professor:" + idProfessor);
//		return dao.listarTreinosDoProfessor(idProfessor);
//	}
//
//}
