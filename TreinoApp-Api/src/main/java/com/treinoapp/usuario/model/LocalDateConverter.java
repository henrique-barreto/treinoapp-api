package com.treinoapp.usuario.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class LocalDateConverter implements AttributeConverter<LocalDate, java.sql.Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate entityValue) {
		if (entityValue != null) {
			return java.sql.Date.valueOf(entityValue);
		}
		return null;
	}

	@Override
	public LocalDate convertToEntityAttribute(Date databaseValue) {
		if (databaseValue != null) {
			return databaseValue.toLocalDate();
		}
		return null;
	}

}