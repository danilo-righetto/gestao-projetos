package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.QuestionarioAcaoDAO;
import br.com.semear.gestao.dao.RespostaAcaoDAO;
import br.com.semear.gestao.dao.entity.AlternativaPerguntaAcaoEntity;
import br.com.semear.gestao.dao.entity.RespostaAcaoEntity;
import br.com.semear.gestao.model.Acao;
import br.com.semear.gestao.model.AlternativaPerguntaAcao;
import br.com.semear.gestao.model.PerguntaAcao;
import br.com.semear.gestao.model.Reeducando;
import br.com.semear.gestao.model.RespostaAcao;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.ParseService;
import br.com.semear.gestao.service.QuestionarioAcaoService;
import br.com.semear.gestao.service.RespostaAcaoService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class RespostaAcaoServiceImpl implements RespostaAcaoService {
	@Inject
	private ParseService parseService;
	
	//@Inject
	//private AcaoService acaoService;
	
	@Inject
	private ParseService parse;
	
	//@Inject
	//private RespostaAcaoService respostaAcaoService;
	
	@Inject
	private RespostaAcaoDAO respostaAcaoDAO;
	
	@Inject
	private QuestionarioAcaoDAO questionarioAcaoDAO;
	
	@Inject
	private QuestionarioAcaoService questionarioAcaoService;

	@Override
	public void salvarRespostaAcao(String[] respostas, Long idAcao, Usuario usuario, Long reeducando, String tipo, String respostaStatus, Long idResposta) {
		if(respostas != null && respostas.length > 0 && idAcao != null){
			for(int i =0; i < respostas.length;i++){
				String[] respostaArray = respostas[i].split("#");
				int idPergunta = Integer.parseInt(respostaArray[0].toString());
				PerguntaAcao pergunta = questionarioAcaoService.buscarPerguntaPorIdAcaoEiDPergunta(idPergunta,idAcao);
				String descricaoResposta = "";
				descricaoResposta = respostaArray[1];
				idResposta = Long.valueOf(respostaArray[2]);
				
				RespostaAcaoEntity respostaAcao = new RespostaAcaoEntity();
				if(idResposta != 0){
					respostaAcao.setId(idResposta);
				}
				respostaAcao.setDataCadastro(Calendar.getInstance());
				respostaAcao.setAcao(parseService.parseToEntity(new Acao(idAcao)));
				respostaAcao.setDescricaoRespostaAcao(descricaoResposta);
				respostaAcao.setPerguntaAcaoEntity(parseService.parseToEntity(pergunta));
				respostaAcao.setUsuarioEntity(parseService.parseToEntity(usuario));
				respostaAcao.setReeducandoEntity(parseService.parseToEntity(new Reeducando(reeducando)));
				respostaAcao.setTipo(tipo);
				respostaAcao.setRespostaStatus(respostaStatus);
				respostaAcaoDAO.salvarRespostaAcao(respostaAcao);
			}
		}
	}

	@Override
	public void alterarRespostaAcao(RespostaAcao resposta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerRespostaAcao(RespostaAcao resposta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RespostaAcao buscarRespostaAcaoPorId(long IdResposta) {
		RespostaAcaoEntity entity = respostaAcaoDAO.buscarRespostaAcaoPorId(IdResposta);
		RespostaAcao respostaAcao = parseService.parseToModel(entity);
		return respostaAcao;
	}

	@Override
	public List<RespostaAcao> listarRespostas() {
		List<RespostaAcaoEntity> lista = respostaAcaoDAO.listarRespostas();
		List<RespostaAcao> respostas = new ArrayList<RespostaAcao>();
		for(RespostaAcaoEntity q: lista){
			respostas.add(parseService.parseToModel(q));
		}
		return respostas;
	}

	@Override
	public void salvarRespostaAcao(List<RespostaAcao> respostas) {
		RespostaAcaoEntity respostaAcao = new RespostaAcaoEntity();
		respostaAcao.setDataCadastro(Calendar.getInstance());
		respostaAcao.setDataAlteracao(Calendar.getInstance());
		respostaAcao.setDescricaoRespostaAcao(((RespostaAcaoEntity) respostas).getDescricaoRespostaAcao());
		respostaAcao.setPerguntaAcaoEntity(parse.parseToEntity(((RespostaAcao) respostas).getPerguntaAcao()));
		respostaAcao.setUsuarioEntity(parse.parseToEntity(((RespostaAcao) respostas).getUsuario()));
		respostaAcao.setTipo(((RespostaAcaoEntity)respostas).getTipo());
		respostaAcao.setRespostaStatus(((RespostaAcaoEntity)respostas).getRespostaStatus());
		respostaAcao.setReeducandoEntity(parse.parseToEntity(((RespostaAcao) respostas).getReeducando()));
		respostaAcao.setAcao(parse.parseToEntity(((RespostaAcao) respostas).getAcao()));
		respostaAcaoDAO.salvarRespostaAcao(respostaAcao);
		
	}

	@Override
	public List<RespostaAcao> listarRespostasReeducandoPorAcaoTipo(long idReeducando, Long idAcao, String tipo) {
		List<RespostaAcaoEntity> lista = respostaAcaoDAO.listarRespostasReeducandoPorAcaoTipo(idReeducando, idAcao, tipo);
		List<RespostaAcao> respostaAcao = new ArrayList<RespostaAcao>();
		for (RespostaAcaoEntity entity : lista) {
			RespostaAcao resposta = parse.parseToModel(entity);
			List<AlternativaPerguntaAcaoEntity> alternativasEntity = questionarioAcaoDAO.buscarAlternativasPorIdPergunta(resposta.getPerguntaAcao().getId());
			for(AlternativaPerguntaAcaoEntity a : alternativasEntity){
				AlternativaPerguntaAcao alternativa = parse.parseToModel(a);
				resposta.getPerguntaAcao().getAlternativas().add(alternativa);
			}
			respostaAcao.add(resposta);
		}
		return respostaAcao;
	}


}
