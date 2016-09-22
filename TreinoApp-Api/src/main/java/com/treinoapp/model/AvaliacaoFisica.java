package com.treinoapp.model;

import javax.persistence.Embedded;
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

	@Embedded
	private Anamnese anamnese;

	@Embedded
	private Dobras dobras;

	@Embedded
	private Perimetria perimetria;

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

	public Anamnese getAnamnese() {
		return anamnese;
	}

	public void setAnamnese(Anamnese anamnese) {
		this.anamnese = anamnese;
	}

	public Dobras getDobras() {
		return dobras;
	}

	public void setDobras(Dobras dobras) {
		this.dobras = dobras;
	}

	public Perimetria getPerimetria() {
		return perimetria;
	}

	public void setPerimetria(Perimetria perimetria) {
		this.perimetria = perimetria;
	}

}
