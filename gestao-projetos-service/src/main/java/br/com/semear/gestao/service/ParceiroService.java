package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.Parceiro;

public interface ParceiroService {
	public String cadastrarParceiro(Parceiro parceiro);
	
	public List<Parceiro> listarParceiros();
	
	public Parceiro buscarParceiroPorId(Long idParceiro);

	public void editarParceiro(Parceiro parceiro);
	
	public Parceiro buscarParceiroPorDocumento(String documento);
	
	public long buscarUnidadePrisionalPorParceiro(long idParceiro);

	public List<Parceiro> buscarParceiroPorUnidade(long idUnidadePrisional);

	public List<Parceiro> buscarParceirosPorId(Long[] idParceiros);

	public long buscarUnidadePrisionalPorProjeto(long idProjeto);
}