package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.Acao;

public interface AcaoService {
	public void cadastrar(Acao acao);

	public void editar(Acao acao);

	public List<Acao> listarAcoes();

	public Acao buscarAcaoPorId(long idAcao);
}