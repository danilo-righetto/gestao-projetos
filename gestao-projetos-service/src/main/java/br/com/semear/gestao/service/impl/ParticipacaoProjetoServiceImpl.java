package br.com.semear.gestao.service.impl;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ParticipacaoReeducandoProjetoDAO;
import br.com.semear.gestao.dao.entity.ParticipacaoReeducandoProjetoEntity;
import br.com.semear.gestao.model.ParticipacaoColaboradorProjeto;
import br.com.semear.gestao.model.ParticipacaoReeducandoProjeto;
import br.com.semear.gestao.model.Projeto;
import br.com.semear.gestao.model.Reeducando;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.InstituicaoService;
import br.com.semear.gestao.service.ParseService;
import br.com.semear.gestao.service.ParticipacaoColaboradorProjetoService;
import br.com.semear.gestao.service.ParticipacaoProjetoService;
import br.com.semear.gestao.service.ProjetoService;
import br.com.semear.gestao.service.ReeducandoService;
import br.com.semear.gestao.service.UsuarioService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ParticipacaoProjetoServiceImpl implements ParticipacaoProjetoService {

	@Inject
	private ParticipacaoReeducandoProjetoDAO participacaoReeducandoProjetoDAO;

	@Inject
	private UsuarioService usuarioService;

	@Inject
	private ReeducandoService reeducandoService;

	@Inject
	private InstituicaoService instituicaoService;

	@Inject
	private ParseService parse;

	@Inject
	private ProjetoService projetoService;

	@Inject
	private ParticipacaoColaboradorProjetoService participacaoColaboradorProjetoService;

	@Override
	public void cadastrar(Long idProjeto, Long idCoordenador, Long[] idReeducandos, String[] funcoes,
			Long[] idColaboradores) {
		ParticipacaoReeducandoProjeto prp = new ParticipacaoReeducandoProjeto();
		ParticipacaoColaboradorProjeto pcp = new ParticipacaoColaboradorProjeto();
		Projeto projeto = projetoService.buscarProjetoPorId(idProjeto);
		projeto.setCoordenador(new Usuario(idCoordenador));

		prp.setDataEntrada(Calendar.getInstance());
		prp.setProjeto(projeto);

		pcp.setDataEntrada(Calendar.getInstance());
		pcp.setProjeto(projeto);

		int iterator = 0;

		if (idReeducandos != null) {
			for (Long reeducando : idReeducandos) {
				Reeducando r = reeducandoService.buscarReeducandoPorId(reeducando);
				prp.setReeducando((r));
				while (iterator <= funcoes.length) {
					prp.setFuncao(funcoes[iterator]);
					iterator++;
					break;
				}
				participacaoReeducandoProjetoDAO.cadastrar(parse.parseToEntity(prp));
			}
		}
		if (idColaboradores != null) {
			for (Long id : idColaboradores) {
				Usuario colaborador = new Usuario(id);
				pcp.setColaborador(colaborador);
				participacaoColaboradorProjetoService.cadastrar(pcp);
			}
		}
		projetoService.editarProjeto(projeto);
	}

	@Override
	public List<ParticipacaoReeducandoProjetoEntity> listarParticipacaoProjetos() {
		return participacaoReeducandoProjetoDAO.listarParticipacaoProjetos();
	}

	@Override
	public List<Usuario> listarCoPorInstituicao(long idInstituicao, String idPerfil) {
		return usuarioService.buscarUsuarioPorInstituicao(idInstituicao, idPerfil);
	}

	@Override
	public List<Reeducando> listarReeducandosPorUnidadePrisional(long idProjeto) {
		long idUnidadePrisional = instituicaoService.buscarUnidadePrisionalPorProjeto(idProjeto);
		return reeducandoService.listarReeducandosPorUnidadePrisional(idUnidadePrisional);
	}

	@Override
	public List<Usuario> listarColaboradoresDasInstituicoes(Long[] idInstituicoes, String idPerfil) {
		return usuarioService.listarColaboradoresDasInstituicoes(idInstituicoes, idPerfil);
	}
}