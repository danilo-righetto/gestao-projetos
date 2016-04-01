package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.ParticipacaoParceiroProjeto;
import br.com.semear.gestao.model.ParticipacaoReeducandoProjeto;
import br.com.semear.gestao.model.Reeducando;
import br.com.semear.gestao.model.Usuario;

public interface ParticipacaoProjetoService {
	public void cadastrar(Long idProjeto, Long idCoordenador, Long[] idReeducandos, String[] funcoes,
			Long[] idColaboradores);

	public List<ParticipacaoReeducandoProjeto> listarParticipacaoProjetos();

	public List<Usuario> listarCoPorParceiro(long idParceiro, String idPerfil);

	public List<Reeducando> listarReeducandosPorUnidadePrisional(long idUnidadePrisional);

	public List<Usuario> listarColaboradoresDasParceiros(List<Long> parceirosAssociadas, String idPerfil);

	public String cadastrarParticipacaoParceiro(Long idProjeto, Long[] idParceiros);

	public List<ParticipacaoParceiroProjeto> listarParticipacaoParceirosProjeto(long idProjeto);

	public List<ParticipacaoReeducandoProjeto> listarParticipacaoReeducandoProjeto(long idProjeto);

	public List<Usuario> buscarAssociadosProjeto(Long idProjeto);
}