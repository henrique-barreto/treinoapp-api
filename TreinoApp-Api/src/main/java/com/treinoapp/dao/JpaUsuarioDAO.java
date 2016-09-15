package com.treinoapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.treinoapp.model.Usuario;

@Repository
public class JpaUsuarioDAO implements UsuarioDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void adicionar(Usuario usuario) {
		em.persist(usuario);
	}

	@Override
	public void atualizar(Usuario usuario) {
		em.merge(usuario);
	}

	@Override
	public void remover(Long id) {
		em.remove(this.buscarPorId(id));
	}

	@Override
	public Usuario buscarPorId(Long id) {
		return em.find(Usuario.class, id);
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		email = email.trim();
		try {
			String consulta = "select u from Usuario u where u.email = :email";
			TypedQuery<Usuario> query = em.createQuery(consulta, Usuario.class);
			query.setParameter("email", email);
			return query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Nenhum usuario com email: " + email);
			return null;
		}
		
	}
	
	@Override
	public List<Usuario> buscarPorNome(String nome) {
		String consulta = "select u from Usuario u where u.nome like :nome";
		TypedQuery<Usuario> query = em.createQuery(consulta, Usuario.class);
		query.setParameter("nome", "%" + nome + "%");
		return query.getResultList();
	}


	@Override
	public List<Usuario> buscarPorParteEmail(String email) {
		String consulta = "select u from Usuario u where u.email like :email";
		TypedQuery<Usuario> query = em.createQuery(consulta, Usuario.class);
		query.setParameter("email", "%" + email + "%");
		return query.getResultList();
	}

}
