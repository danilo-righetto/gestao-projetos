package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.ParticipacaoParceiroProjetoEntity;

public interface ParticipacaoParceiroProjetoDAO {

	public void cadastrarParticipacaoParceiro(ParticipacaoParceiroProjetoEntity entity);

	public List<ParticipacaoParceiroProjetoEntity> listarParticipacaoParceirosProjeto(long idProjeto);

	public List<Long> buscarParceirosAssociados(long idProjeto);

	public ParticipacaoParceiroProjetoEntity buscarParticipacaoPorProjetoEParceiro(Long idProjeto, Long idParceiro);
}