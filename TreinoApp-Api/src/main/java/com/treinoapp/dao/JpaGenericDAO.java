package com.treinoapp.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.treinoapp.dao.interfaces.GenericDAO;

public abstract class JpaGenericDAO<T, I extends Serializable> implements GenericDAO<T, I> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@PersistenceContext
	protected EntityManager em;

	private Class<T> persistedClass;

	@Deprecated
	protected JpaGenericDAO() {
	}

	protected JpaGenericDAO(Class<T> persistedClass) {
		this();
		this.persistedClass = persistedClass;
	}

	@Override
	public T adicionar(T t) {
		logger.debug("adicionar() JpaGenericDAO persistindo entidade: " + persistedClass.getName());
		em.persist(t);
		em.flush();
		return t;
	}

	@Override
	public T atualizar(T t) {
		logger.debug("atualizar() JpaGenericDAO atualizando entidade: " + persistedClass.getName());
		return em.merge(t);
	}

	@Override
	public void remover(I id) {
		logger.debug("remover() JpaGenericDAO removendo entidade: " + persistedClass.getName() + " com id: " + id);
		em.remove(id);
	}

	@Override
	public T buscarPorId(I id) {
		logger.debug("buscarPorId() JpaGenericDAO buscando entidade: " + persistedClass.getName() + " com id: " + id);
		return em.find(persistedClass, id);
	}

}