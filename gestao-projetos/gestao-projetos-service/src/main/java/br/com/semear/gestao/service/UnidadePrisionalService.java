package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.dao.entity.UnidadePrisionalEntity;
import br.com.semear.gestao.model.UnidadePrisional;

public interface UnidadePrisionalService {
	public void cadastrar(UnidadePrisional unidadePrisional);

	public List<UnidadePrisionalEntity> listaUnidades();
}