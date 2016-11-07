package com.treinoapp.usuario.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("ROLE_GERENTE")
@Table(name = "GERENTE")
public class Gerente extends Usuario {
	
	public Gerente(){
		super(Permissao.ROLE_GERENTE);
	}
}
