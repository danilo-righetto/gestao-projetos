package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.ParticipacaoInstituicaoProjeto;
import br.com.semear.gestao.model.ParticipacaoReeducandoProjeto;
import br.com.semear.gestao.model.Reeducando;
import br.com.semear.gestao.model.Usuario;

public interface ParticipacaoProjetoService {
	public void cadastrar(Long idProjeto, Long idCoordenador, Long[] idReeducandos, String[] funcoes,
			Long[] idColaboradores);

	public List<ParticipacaoReeducandoProjeto> listarParticipacaoProjetos();

	public List<Usuario> listarCoPorInstituicao(long idInstituicao, String idPerfil);

	public List<Reeducando> listarReeducandosPorUnidadePrisional(long idUnidadePrisional);

	public List<Usuario> listarColaboradoresDasInstituicoes(List<Long> instituicoesAssociadas, String idPerfil);

	public String cadastrarParticipacaoInstituicao(Long idProjeto, Long[] idInstituicoes);

	public List<ParticipacaoInstituicaoProjeto> listarParticipacaoInstituicoesProjeto(long idProjeto);

	public List<ParticipacaoReeducandoProjeto> listarParticipacaoReeducandoProjeto(long idProjeto);

	public List<Usuario> buscarAssociadosProjeto(Long idProjeto);
}