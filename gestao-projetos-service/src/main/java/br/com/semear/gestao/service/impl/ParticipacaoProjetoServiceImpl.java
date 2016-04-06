package br.com.semear.gestao.service.impl;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ParticipacaoParceiroProjetoDAO;
import br.com.semear.gestao.dao.entity.ParceiroEntity;
import br.com.semear.gestao.dao.entity.ParticipacaoParceiroProjetoEntity;
import br.com.semear.gestao.dao.entity.ProjetoEntity;
import br.com.semear.gestao.model.ParticipacaoColaboradorProjeto;
import br.com.semear.gestao.model.ParticipacaoParceiroProjeto;
import br.com.semear.gestao.model.ParticipacaoReeducandoProjeto;
import br.com.semear.gestao.model.Projeto;
import br.com.semear.gestao.model.Reeducando;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.ParticipacaoColaboradorProjetoService;
import br.com.semear.gestao.service.ParticipacaoParceiroProjetoService;
import br.com.semear.gestao.service.ParticipacaoProjetoService;
import br.com.semear.gestao.service.ParticipacaoReeducandoProjetoService;
import br.com.semear.gestao.service.ProjetoService;
import br.com.semear.gestao.service.ReeducandoService;
import br.com.semear.gestao.service.UsuarioService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ParticipacaoProjetoServiceImpl implements ParticipacaoProjetoService {

	@Inject
	private ParticipacaoReeducandoProjetoService participacaoReeducandoProjetoService;

	@Inject
	private UsuarioService usuarioService;

	@Inject
	private ReeducandoService reeducandoService;

	@Inject
	private ProjetoService projetoService;

	@Inject
	private ParticipacaoColaboradorProjetoService participacaoColaboradorProjetoService;

	@Inject
	private ParticipacaoParceiroProjetoService participacaoParceiroProjetoService;

	@Inject
	private ParticipacaoParceiroProjetoDAO participacaoParceiroProjetoDAO;

	@Override
	public String cadastrarParticipacaoParceiro(Long idProjeto, Long[] idParceiros) {
		String msg = null;
		try {
			if (idParceiros != null) {
				for (Long id : idParceiros) {
					ParticipacaoParceiroProjetoEntity pip = participacaoParceiroProjetoDAO
							.buscarParticipacaoPorProjetoEParceiro(idProjeto, id);
					if (pip == null) {
						pip = new ParticipacaoParceiroProjetoEntity();
						pip.setDataEntrada(Calendar.getInstance());
						pip.setProjeto(new ProjetoEntity(idProjeto));
						pip.setParceiro(new ParceiroEntity(id));
						participacaoParceiroProjetoDAO.cadastrarParticipacaoParceiro(pip);
					}
				}
			}
			msg = "OK";
		} catch (Exception e) {
			msg = "NOK";
		}
		return msg;
	}

	@Override
	public void cadastrar(Long idProjeto, Long idCoordenador, Long[] idReeducandos, String[] funcoes,
			Long[] idColaboradores) {
		Projeto projeto = projetoService.buscarProjetoPorId(idProjeto);
		projeto.setCoordenador(new Usuario(idCoordenador));
		projetoService.editarProjeto(projeto);
		projeto = projetoService.buscarProjetoPorId(idProjeto);
		ParticipacaoReeducandoProjeto prp = new ParticipacaoReeducandoProjeto();
		ParticipacaoColaboradorProjeto pcp = new ParticipacaoColaboradorProjeto();

		prp.setDataEntrada(Calendar.getInstance());
		prp.setProjeto(projeto);

		pcp.setDataEntrada(Calendar.getInstance());
		pcp.setProjeto(projeto);

		int iterator = 0;

		if (idReeducandos != null) {
			for (Long id : idReeducandos) {
				Reeducando reeducando = reeducandoService.buscarReeducandoPorId(id);
				prp.setReeducando((reeducando));
				while (iterator <= funcoes.length) {
					prp.setFuncao(funcoes[iterator]);
					iterator++;
					break;
				}
				participacaoReeducandoProjetoService.cadastrar(prp);
			}
		}
		if (idColaboradores != null) {
			for (Long id : idColaboradores) {
				Usuario usuario = new Usuario(id);
				pcp.setColaborador(usuario);
				participacaoColaboradorProjetoService.cadastrar(pcp);
			}
		}
	}

	@Override
	public List<ParticipacaoReeducandoProjeto> listarParticipacaoProjetos() {
		return participacaoReeducandoProjetoService.listarParticipacaoProjetos();
	}

	@Override
	public List<Usuario> listarCoordenadoresDoParceiro(long idParceiro, String idPerfil) {
		return usuarioService.listarCoordenadoresDoParceiro(idParceiro, idPerfil);
	}

	@Override
	public List<Reeducando> listarReeducandosPorUnidadePrisional(long idProjeto) {
		long idUnidadePrisional = projetoService.buscarUnidadePrisionalDoProjeto(idProjeto);
		return reeducandoService.listarReeducandosPorUnidadePrisional(idUnidadePrisional);
	}

	@Override
	public List<Usuario> listarColaboradoresDosParceiros(List<Long> idParceiros, String idPerfil) {
		return usuarioService.listarColaboradoresDosParceiros(idParceiros, idPerfil);
	}

	@Override
	public List<ParticipacaoParceiroProjeto> listarParticipacaoParceirosProjeto(long idProjeto) {
		return participacaoParceiroProjetoService.listarParticipacaoParceirosProjeto(idProjeto);
	}

	@Override
	public List<ParticipacaoReeducandoProjeto> listarParticipacaoReeducandoProjeto(long idProjeto) {
		return participacaoReeducandoProjetoService.listarParticipacaoProjetos(idProjeto);
	}

	@Override
	public List<Usuario> listarAssociadosDoProjeto(Long idProjeto) {
		return participacaoColaboradorProjetoService.listarAssociadosDoProjeto(idProjeto);
	}
}