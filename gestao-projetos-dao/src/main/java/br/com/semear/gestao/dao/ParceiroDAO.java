package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.ParceiroEntity;

public interface ParceiroDAO {
	public long cadastrarParceiro(ParceiroEntity parceiro);
	
	public List<ParceiroEntity> listarParceiros();

	public void editarParceiro(ParceiroEntity parceiro);

	public ParceiroEntity buscarParceiroPorId(Long idParceiro);
	
	public ParceiroEntity buscarParceiroPorDocumento(String documento);

	public long buscarUnidadePrisionalPorParceiro(long idParceiro);

	public List<ParceiroEntity> buscarParceiroPorUnidade(long idUnidadePrisional);

	public List<ParceiroEntity> buscarParceiroPorId(Long[] idParceiros);
}