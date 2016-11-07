package com.treinoapp.usuario.service.interfaces;

import java.util.List;

import com.treinoapp.usuario.model.Secretaria;

public interface SecretariaService {

	Secretaria buscarPorId(Long id);

	List<Secretaria> buscarPorNome(String nome);

	List<Secretaria> buscarPorEmailContendo(String parteEmail);

}
