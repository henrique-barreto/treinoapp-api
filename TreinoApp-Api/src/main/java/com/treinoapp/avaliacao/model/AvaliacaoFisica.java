package com.treinoapp.avaliacao.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.treinoapp.avaliacao.calculadora.CalculadoraBF;
import com.treinoapp.avaliacao.calculadora.ResultadoAvaliacao;
import com.treinoapp.usuario.model.Aluno;
import com.treinoapp.usuario.model.Professor;

@Entity
public class AvaliacaoFisica {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ALUNO_ID")
	private Aluno aluno;

	@ManyToOne(fetch = FetchType.EAGER)
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
	
	@JsonIgnore
	public ResultadoAvaliacao getResultado() {
		return new CalculadoraBF(this).getResultado();
	}
	
}
