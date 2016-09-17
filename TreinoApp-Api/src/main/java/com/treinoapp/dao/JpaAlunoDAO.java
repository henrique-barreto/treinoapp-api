package com.treinoapp.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.treinoapp.dao.interfaces.AlunoDAO;
import com.treinoapp.model.Aluno;

@Repository
public class JpaAlunoDAO extends JpaGenericDAO<Aluno, Long> implements AlunoDAO {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public JpaAlunoDAO() {
		super(Aluno.class);
	}

	@Override
	public Aluno buscarPorEmail(String email) {

		logger.debug("buscarPorEmail() Buscar aluno por email: " + email);
		email = email.trim();
		try {
			String consulta = "select a from Aluno a where a.email = :email";
			TypedQuery<Aluno> query = em.createQuery(consulta, Aluno.class);
			query.setParameter("email", email);
			return query.getSingleResult();
		} catch (NoResultException e) {
			logger.debug("Nenhum aluno com email: " + email);
			return null;
		}
	}

	@Override
	public List<Aluno> buscarPorNome(String nome) {
		logger.debug("buscarPorNome() Buscar aluno por nome: " + nome);
		String consulta = "select a from Aluno a where a.nome like :nome";
		TypedQuery<Aluno> query = em.createQuery(consulta, Aluno.class);
		query.setParameter("nome", "%" + nome + "%");
		return query.getResultList();
	}

	@Override
	public List<Aluno> buscarPorParteEmail(String email) {
		logger.debug("buscarPorParteEmail() Buscar aluno por parte email: " + email);
		String consulta = "select a from Aluno a where a.email like :email";
		TypedQuery<Aluno> query = em.createQuery(consulta, Aluno.class);
		query.setParameter("email", "%" + email + "%");
		return query.getResultList();
	}

}
