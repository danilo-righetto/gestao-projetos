package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.RespostaAcaoDAO;
import br.com.semear.gestao.dao.entity.RespostaAcaoEntity;
import br.com.semear.gestao.model.PerguntaAcao;
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
	
	@Inject
	private RespostaAcaoDAO respostaAcaoDAO;
	
	@Inject
	private QuestionarioAcaoService questionarioAcaoService;

	@Override
	public void salvarRespostaAcao(String[] respostas, Long idAcao, Usuario usuario) {
		if(respostas != null && respostas.length > 0 && idAcao != null){
			for(int i =0; i < respostas.length;i++){
				String[] respostaArray = respostas[i].split("#");
				int idPergunta = Integer.parseInt(respostaArray[0].toString());
				PerguntaAcao pergunta = questionarioAcaoService.buscarPerguntaPorIdAcaoEiDPergunta(idPergunta,idAcao);
				String descricaoResposta = "";
				descricaoResposta = respostaArray[1];
				
				RespostaAcaoEntity respostaAcao = new RespostaAcaoEntity();
				respostaAcao.setDataCadastro(Calendar.getInstance());
				respostaAcao.setDescricaoRespostaAcao(descricaoResposta);
				respostaAcao.setPerguntaAcaoEntity(parseService.parseToEntity(pergunta));
				respostaAcao.setUsuarioEntity(parseService.parseToEntity(usuario));
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

}
