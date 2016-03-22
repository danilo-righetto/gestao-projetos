package br.com.semear.gestao.dao;

import br.com.semear.gestao.dao.entity.InformacaoProjetoEntity;

public interface InformacaoProjetoDAO {
	public void cadastrar(InformacaoProjetoEntity informacaoProjetoEntity);

	public InformacaoProjetoEntity buscarInformacaoProjetoPorIdProjeto(Long idProjeto);
}