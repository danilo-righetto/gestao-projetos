package br.com.semear.gestao.service.impl;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ParticipacaoInstituicaoProjetoDAO;
import br.com.semear.gestao.dao.entity.InstituicaoEntity;
import br.com.semear.gestao.dao.entity.ParticipacaoInstituicaoProjetoEntity;
import br.com.semear.gestao.dao.entity.ProjetoEntity;
import br.com.semear.gestao.model.ParticipacaoColaboradorProjeto;
import br.com.semear.gestao.model.ParticipacaoInstituicaoProjeto;
import br.com.semear.gestao.model.ParticipacaoReeducandoProjeto;
import br.com.semear.gestao.model.Projeto;
import br.com.semear.gestao.model.Reeducando;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.ParticipacaoColaboradorProjetoService;
import br.com.semear.gestao.service.ParticipacaoInstituicaoProjetoService;
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
	private ParticipacaoInstituicaoProjetoService participacaoInstituicaoProjetoService;
	
	@Inject
	private ParticipacaoInstituicaoProjetoDAO participacaoInstituicaoProjetoDAO;
	
	@Override
	public String cadastrarParticipacaoInstituicao(Long idProjeto, Long[] idInstituicoes){
		String msg = null;
		try{
			if(idInstituicoes != null){
				for(Long id : idInstituicoes){
					ParticipacaoInstituicaoProjetoEntity pip = participacaoInstituicaoProjetoDAO.buscarParticipacaoPorProjetoEInstituicao(idProjeto,id);
					if(pip == null){
						pip = new ParticipacaoInstituicaoProjetoEntity();
						pip.setDataEntrada(Calendar.getInstance());
						pip.setProjeto(new ProjetoEntity(idProjeto));
						pip.setInstituicao(new InstituicaoEntity(id));
						participacaoInstituicaoProjetoDAO.cadastrarParticipacaoInstituicao(pip);
					}
				}
			}
			msg = "OK";
		}catch(Exception e){
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
				Usuario colaborador = new Usuario(id);
				pcp.setColaborador(colaborador);
				participacaoColaboradorProjetoService.cadastrar(pcp);
			}
		}
	}

	@Override
	public List<ParticipacaoReeducandoProjeto> listarParticipacaoProjetos() {
		return participacaoReeducandoProjetoService.listarParticipacaoProjetos();
	}

	@Override
	public List<Usuario> listarCoPorInstituicao(long idInstituicao, String idPerfil) {
		return usuarioService.buscarUsuarioPorInstituicao(idInstituicao, idPerfil);
	}

	@Override
	public List<Reeducando> listarReeducandosPorUnidadePrisional(long idProjeto) {
		long idUnidadePrisional = projetoService.buscarUnidadePrisionalDoProjeto(idProjeto);
		return reeducandoService.listarReeducandosPorUnidadePrisional(idUnidadePrisional);
	}

	@Override
	public List<Usuario> listarColaboradoresDasInstituicoes(List<Long> idInstituicoes, String idPerfil) {
		return usuarioService.listarColaboradoresDasInstituicoes(idInstituicoes, idPerfil);
	}

	@Override
	public List<ParticipacaoInstituicaoProjeto> listarParticipacaoInstituicoesProjeto(long idProjeto) {
		return participacaoInstituicaoProjetoService.listarParticipacaoInstituicoesProjeto(idProjeto);
	}

	@Override
	public List<ParticipacaoReeducandoProjeto> listarParticipacaoReeducandoProjeto(long idProjeto) {
		return participacaoReeducandoProjetoService.listarParticipacaoProjetos(idProjeto);
	}

	@Override
	public List<Usuario> buscarAssociadosProjeto(Long idProjeto) {
		List<Usuario> usuarios = participacaoColaboradorProjetoService.buscarColaboradoresAssociados(idProjeto);
		List<Usuario> reeducandos = participacaoReeducandoProjetoService.buscarReeducandosAssociados(idProjeto);

		usuarios.addAll(reeducandos);
		
		return usuarios;
	}
}