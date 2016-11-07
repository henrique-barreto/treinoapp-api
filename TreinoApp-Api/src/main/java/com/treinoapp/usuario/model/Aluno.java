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
@DiscriminatorValue("ROLE_ALUNO")
@Table(name = "ALUNO")
public class Aluno extends Usuario {

	@OneToMany(mappedBy = "aluno")
	@JsonIgnore
	private List<Treino> treinos;
	
	@OneToMany(mappedBy = "aluno")
	@JsonIgnore
	private List<AvaliacaoFisica> avaliacoes;
	
	public Aluno() {
		super(Permissao.ROLE_ALUNO);
	}
	
	public Aluno(UsuarioDto dto) {
		super(Permissao.ROLE_ALUNO, dto);
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
