package com.treinoapp.dao;

import org.springframework.stereotype.Repository;

import com.treinoapp.dao.interfaces.AvaliacaoFisicaDAO;
import com.treinoapp.model.AvaliacaoFisica;

@Repository
public class JpaAvaliacaoFisicaDAO extends JpaGenericDAO<AvaliacaoFisica, Long>  implements AvaliacaoFisicaDAO{

	public JpaAvaliacaoFisicaDAO() {
		super(AvaliacaoFisica.class);
	}
	
}
