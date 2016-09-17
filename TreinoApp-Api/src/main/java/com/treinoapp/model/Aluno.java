package com.treinoapp.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("ALUNO")
@Table(name = "ALUNO")
public class Aluno extends Usuario {

	@JsonIgnore
	@OneToMany(mappedBy = "aluno")
	private List<Treino> treinos;
	
	@JsonIgnore
	@OneToMany(mappedBy = "aluno")
	private List<AvaliacaoFisica> avaliacoes;

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
