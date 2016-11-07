package com.treinoapp.usuario.service.interfaces;

import java.util.List;

import com.treinoapp.usuario.model.Gerente;

public interface GerenteService {

	Gerente buscarPorId(Long id);

	List<Gerente> buscarPorNome(String nome);

	List<Gerente> buscarPorEmailContendo(String parteEmail);

}
