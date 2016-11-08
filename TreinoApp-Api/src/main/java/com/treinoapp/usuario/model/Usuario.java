package com.treinoapp.usuario.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.treinoapp.usuario.dto.UsuarioDto;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PERMISSAO")
@Table(name = "USUARIO")
public abstract class Usuario {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String email;

	@NotNull
	private String nome;

	@JsonIgnore
	private String senha;

	@Enumerated(EnumType.STRING)
	@Column(name = "PERMISSAO", insertable = false)
	private Permissao permissao;

	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	private String telefone;

	@JsonIgnore
	@Convert(converter = LocalDateConverter.class)
	@Column(name = "data_criacao")
	private LocalDate dataNascimento;

	@Deprecated
	public Usuario() {
	}

	public Usuario(Permissao permissao) {
		this.permissao = permissao;
	}

	public Usuario(Permissao permissao, UsuarioDto dto) {
		this.permissao = permissao;
		this.email = dto.getEmail();
		this.nome = dto.getNome();
		this.telefone = dto.getTelefone();

		Sexo sexo = dto.getSexo().equalsIgnoreCase("Masculino") ? Sexo.MASCULINO : Sexo.FEMININO;
		this.setSexo(sexo);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(dto.getDataNascimento(), fmt);
		this.dataNascimento = localDate;
		this.senha = dto.getSenha();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		LocalDate today = LocalDate.now();
		Period p = Period.between(dataNascimento, today);
		return p.getYears();
	}

	@JsonIgnore
	public String getSenha() {
		return senha;
	}

	@JsonProperty
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
