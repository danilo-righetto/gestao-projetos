package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.UnidadePrisional;

public interface UnidadePrisionalService {
	public void cadastrar(UnidadePrisional unidadePrisional);

	public void editar(UnidadePrisional unidadePrisional);

	public void excluir(UnidadePrisional unidadePrisional);

	public List<UnidadePrisional> listaUnidades();

	public UnidadePrisional buscarUnidadePrisionalPorId(long idUnidadePrisional);

	public List<UnidadePrisional> buscarUnidadePrisionalPorParceiro(long idParceiro);

	public List<UnidadePrisional> listarUnidadesPorStatus(boolean status);

	public void adicionarVinculoParceiroComUnidadePrisional(long idParceiro, long idUnidadePrisional);
}