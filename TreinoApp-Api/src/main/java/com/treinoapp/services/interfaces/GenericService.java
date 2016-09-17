package com.treinoapp.services.interfaces;

import java.io.Serializable;

public interface GenericService<T, I extends Serializable> {

	T adicionar(T t);

	T atualizar(T t);

	void remover(I id);

	T buscarPorId(I I);

}
