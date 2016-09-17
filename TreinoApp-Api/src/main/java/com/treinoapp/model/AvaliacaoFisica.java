package com.treinoapp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AvaliacaoFisica {

	@Id
	@GeneratedValue
	private Long id;

	private String percentualGordura;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ALUNO_ID")
	private Aluno aluno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROFESSOR_ID")
	private Professor professor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPercentualGordura() {
		return percentualGordura;
	}

	public void setPercentualGordura(String percentualGordura) {
		this.percentualGordura = percentualGordura;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
}
