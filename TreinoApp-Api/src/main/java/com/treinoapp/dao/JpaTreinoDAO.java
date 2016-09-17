package com.treinoapp.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.treinoapp.dao.interfaces.TreinoDAO;
import com.treinoapp.model.Treino;

@Repository
public class JpaTreinoDAO extends JpaGenericDAO<Treino, Long> implements TreinoDAO {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public JpaTreinoDAO() {
		super(Treino.class);
	}

	@Override
	public Treino buscarTreinoAtivo(Long idAluno) {
		logger.debug("buscarTreinoAtivo() Buscando treino ativo do aluno: " + idAluno);
		throw new RuntimeException("Metodo nao implementado");
	}

	@Override
	public List<Treino> listarTreinos(Long idAluno) {

		logger.debug("listarTreinos() Listando treinos do aluno: " + idAluno);

		String consulta = "select t from Treino t where t.aluno.id = :idAluno";
		TypedQuery<Treino> query = em.createQuery(consulta, Treino.class);
		query.setParameter("idAluno", idAluno);
		return query.getResultList();
	}

	@Override
	public List<Treino> listarTreinosDoProfessor(Long idProfessor) {

		logger.debug("listarTreinosDoProfessor() Listando treinos do professor: " + idProfessor);

		String consulta = "select t from Treino t where t.professor.id = :idProfessor";
		TypedQuery<Treino> query = em.createQuery(consulta, Treino.class);
		query.setParameter("idProfessor", idProfessor);
		return query.getResultList();
	}

}
