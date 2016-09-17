package com.treinoapp.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.treinoapp.dao.interfaces.ProfessorDAO;
import com.treinoapp.model.Professor;

@Repository
public class JpaProfessorDAO extends JpaGenericDAO<Professor, Long> implements ProfessorDAO {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public JpaProfessorDAO() {
		super(Professor.class);
	}

	@Override
	public Professor buscarPorEmail(String email) {
		logger.debug("buscarPorEmail() JPA buscar dadastro de professor por email: " + email);
		email = email.trim();
		try {
			String consulta = "select p from Professor p where p.email = :email";
			TypedQuery<Professor> query = em.createQuery(consulta, Professor.class);
			query.setParameter("email", email);
			return query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Nenhum aluno com email: " + email);
			return null;
		}
	}

	@Override
	public List<Professor> buscarPorNome(String nome) {
		logger.debug("buscarPorNome() JPA buscar dadastro de professor por nome: " + nome);
		String consulta = "select p from Professor p where p.nome like :nome";
		TypedQuery<Professor> query = em.createQuery(consulta, Professor.class);
		query.setParameter("nome", "%" + nome + "%");
		return query.getResultList();
	}

	@Override
	public List<Professor> buscarPorParteEmail(String email) {
		logger.debug("buscarPorParteEmail() JPA buscar dadastro de professor por parte de email: " + email);
		String consulta = "select p from Professor p where p.email like :email";
		TypedQuery<Professor> query = em.createQuery(consulta, Professor.class);
		query.setParameter("email", "%" + email + "%");
		return query.getResultList();
	}

}
