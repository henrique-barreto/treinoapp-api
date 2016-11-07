package com.treinoapp.usuario.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.treinoapp.avaliacao.model.AvaliacaoFisica;
import com.treinoapp.treino.model.Treino;
import com.treinoapp.usuario.dto.UsuarioDto;

@Entity
@DiscriminatorValue("ROLE_PROFESSOR")
@Table(name = "PROFESSOR")
public class Professor extends Usuario {

	@JsonIgnore
	@OneToMany(mappedBy = "professor")
	private List<Treino> treinos;

	@JsonIgnore
	@OneToMany(mappedBy = "professor")
	private List<AvaliacaoFisica> avaliacoes;
	
	public Professor(UsuarioDto dto) {
		super(Permissao.ROLE_ALUNO, dto);
	}
	
	public Professor() {
		super(Permissao.ROLE_PROFESSOR);
	}
	
	public List<Treino> getTreinos() {
		return treinos;
	}

	public void setTreinos(List<Treino> treinos) {
		this.treinos = treinos;
	}

	public List<AvaliacaoFisica> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<AvaliacaoFisica> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

}
