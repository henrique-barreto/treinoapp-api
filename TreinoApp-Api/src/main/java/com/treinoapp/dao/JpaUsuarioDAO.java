package com.treinoapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
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
		System.out.println("JpaUsuarioDAO... ");
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
	public List<Usuario> buscarPorNome(String nome) {
		String consulta = "select u from Usuario u where u.nome like :nome";
		TypedQuery<Usuario> query = em.createQuery(consulta, Usuario.class);
		query.setParameter("nome", "%" + nome + "%");
		return query.getResultList();
	}

}
