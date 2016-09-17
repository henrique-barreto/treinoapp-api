package com.treinoapp.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("SECRETARIA")
@Table(name = "SECRETARIA")
public class Secretaria extends Usuario {

}
