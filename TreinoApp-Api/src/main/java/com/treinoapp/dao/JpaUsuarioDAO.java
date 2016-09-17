package com.treinoapp.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.treinoapp.dao.interfaces.UsuarioDAO;
import com.treinoapp.model.Usuario;

@Repository
public class JpaUsuarioDAO extends JpaGenericDAO<Usuario, Long> implements UsuarioDAO {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public JpaUsuarioDAO() {
		super(Usuario.class);
	}

	@Override
	public Usuario buscarPorEmail(String email) {

		logger.debug("buscarPorEmail() Buscando usuario por email: " + email);

		email = email.trim();
		try {
			String consulta = "select u from Usuario u where u.email = :email";
			TypedQuery<Usuario> query = em.createQuery(consulta, Usuario.class);
			query.setParameter("email", email);
			return query.getSingleResult();
		} catch (NoResultException e) {
			logger.debug("buscarPorEmail() Nenhum usuario com email: " + email);
			return null;
		}

	}

	@Override
	public List<Usuario> buscarPorNome(String nome) {
		logger.debug("buscarPorNome() Buscando usuario por nome: " + nome);
		String consulta = "select u from Usuario u where u.nome like :nome";
		TypedQuery<Usuario> query = em.createQuery(consulta, Usuario.class);
		query.setParameter("nome", "%" + nome + "%");
		return query.getResultList();
	}

	@Override
	public List<Usuario> buscarPorParteEmail(String email) {
		logger.debug("buscarPorParteEmail() Buscando usuario por parte email: " + email);
		String consulta = "select u from Usuario u where u.email like :email";
		TypedQuery<Usuario> query = em.createQuery(consulta, Usuario.class);
		query.setParameter("email", "%" + email + "%");
		return query.getResultList();
	}

}
