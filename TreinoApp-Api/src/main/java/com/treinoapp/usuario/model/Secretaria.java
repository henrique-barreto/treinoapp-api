package com.treinoapp.usuario.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("ROLE_SECRETARIA")
@Table(name = "SECRETARIA")
public class Secretaria extends Usuario {
	
	public Secretaria(){
		super(Permissao.ROLE_SECRETARIA);
	}
}
