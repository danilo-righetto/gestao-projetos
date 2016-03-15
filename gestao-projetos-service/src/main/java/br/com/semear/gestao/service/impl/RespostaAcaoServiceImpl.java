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
import br.com.semear.gestao.model.RespostaAcao;
import br.com.semear.gestao.service.ParseService;
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

	@Override
	public void salvarRespostaAcao(List<RespostaAcao> respostas) {
		RespostaAcaoEntity respostaAcao = new RespostaAcaoEntity();
		respostaAcao.setDataCadastro(Calendar.getInstance());
		respostaAcao.setDataAlteracao(Calendar.getInstance());
		respostaAcao.setDescricaoRespostaAcao(((RespostaAcaoEntity) respostas).getDescricaoRespostaAcao());
		respostaAcao.setPerguntaAcaoEntity(parse.parseToEntity(((RespostaAcao) respostas).getPerguntaAcao()));
		respostaAcao.setUsuarioEntity(parse.parseToEntity(((RespostaAcao) respostas).getUsuario()));
		respostaAcaoDAO.salvarRespostaAcao(respostaAcao);
		
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
		RespostaAcao respostaAcao = parse.parseToModel(entity);
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
