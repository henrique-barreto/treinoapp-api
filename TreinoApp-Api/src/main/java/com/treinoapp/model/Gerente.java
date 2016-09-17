package com.treinoapp.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("GERENTE")
@Table(name = "GERENTE")
public class Gerente extends Usuario {

}
