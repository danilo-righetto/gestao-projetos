package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.dao.entity.ParticipacaoReeducandoProjetoEntity;
import br.com.semear.gestao.model.ParticipacaoInstituicaoProjeto;
import br.com.semear.gestao.model.Reeducando;
import br.com.semear.gestao.model.Usuario;

public interface ParticipacaoProjetoService {
	public void cadastrar(Long idProjeto, Long idCoordenador, Long[] idReeducandos, String[] funcoes,
			Long[] idColaboradores);

	public List<ParticipacaoReeducandoProjetoEntity> listarParticipacaoProjetos();

	public List<Usuario> listarCoPorInstituicao(long idInstituicao, String idPerfil);

	public List<Reeducando> listarReeducandosPorUnidadePrisional(long idUnidadePrisional);

	public List<Usuario> listarColaboradoresDasInstituicoes(List<Long> instituicoesAssociadas, String idPerfil);

	public void cadastrarParticipacaoInstituicao(Long idProjeto, Long[] idInstituicoes);

	public List<ParticipacaoInstituicaoProjeto> listarParticipacaoInstituicoesProjeto(long idProjeto);
}