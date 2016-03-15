package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.ParticipacaoInstituicaoProjetoEntity;

public interface ParticipacaoInstituicaoProjetoDAO {

	public void cadastrarParticipacaoInstituicao(ParticipacaoInstituicaoProjetoEntity entity);

	public List<ParticipacaoInstituicaoProjetoEntity> listarParticipacaoInstituicoesProjeto(long idProjeto);

	public List<Long> buscarInstituicoesAssociadas(long idProjeto);
}