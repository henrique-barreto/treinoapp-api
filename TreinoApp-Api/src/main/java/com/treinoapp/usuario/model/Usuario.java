package com.treinoapp.usuario.model;

import javax.persistence.Column;
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

	private int idade;

	@JsonIgnore
	private String senha;

	@Enumerated(EnumType.STRING)
	@Column(name = "PERMISSAO", insertable = false)
	private Permissao permissao;

	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@Deprecated
	public Usuario() {
	}

	public Usuario(Permissao permissao) {
		this.permissao = permissao;
	}

	public Usuario(Permissao permissao, UsuarioDto dto) {
		this.permissao = permissao;
		this.email = dto.getEmail();
		this.idade = dto.getIdade();
		this.nome = dto.getNome();
		this.senha = dto.getSenha();
		this.sexo = dto.getSexo();
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
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
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

}
