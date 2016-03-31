package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.RespostaProjetoDAO;
import br.com.semear.gestao.dao.entity.RespostaEntity;
import br.com.semear.gestao.model.Pergunta;
import br.com.semear.gestao.model.Projeto;
import br.com.semear.gestao.model.Reeducando;
import br.com.semear.gestao.model.Resposta;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.ParseService;
import br.com.semear.gestao.service.QuestionarioService;
import br.com.semear.gestao.service.RespostaProjetoService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class RespostaProjetoServiceImpl implements RespostaProjetoService {
	@Inject
	private ParseService parseService;
	
	@Inject
	private RespostaProjetoDAO respostaProjetoDAO;
	
	@Inject
	private QuestionarioService questionarioService;

	@Override
	public void alterarRespostaProjeto(Resposta resposta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removerResposta(Resposta resposta) {
		// TODO Auto-generated method stub

	}

	@Override
	public Resposta buscarRespostaProjetoPorId(long IdResposta) {
		RespostaEntity entity = respostaProjetoDAO.buscarRespostaProjetoPorId(IdResposta);
		Resposta respostaProjeto = parseService.parseToModel(entity);
		return respostaProjeto;
	}

	@Override
	public List<Resposta> listarRespostas() {
		List<RespostaEntity> lista = respostaProjetoDAO.listarRespostas();
		List<Resposta> respostas = new ArrayList<Resposta>();
		for(RespostaEntity q: lista){
			respostas.add(parseService.parseToModel(q));
		}
		return respostas;
	}

	@Override
	public void salvarResposta(String[] respostas, Long idProjeto, Usuario usuario, Long reeducando, String respostaStatus) {
		if(respostas != null && respostas.length > 0 && idProjeto != null){
			for(int i =0; i < respostas.length;i++){
				String[] respostaArray = respostas[i].split("#");
				int idPergunta = Integer.parseInt(respostaArray[0].toString());
				Pergunta pergunta = questionarioService.buscarPerguntaPorIdProjetoEiDPergunta(idPergunta,idProjeto);
				String descricaoResposta = "";
				descricaoResposta = respostaArray[1];
				
				RespostaEntity resposta = new RespostaEntity();
				resposta.setProjetoEntity(parseService.parseToEntity(new Projeto(idProjeto)));
				resposta.setDataCadastro(Calendar.getInstance());
				resposta.setDescricaoResposta(descricaoResposta);
				resposta.setPerguntaEntity(parseService.parseToEntity(pergunta));
				resposta.setUsuarioEntity(parseService.parseToEntity(usuario));
				resposta.setReeducandoEntity(parseService.parseToEntity(new Reeducando(reeducando)));
				resposta.setRespostaStatus(respostaStatus);
				respostaProjetoDAO.salvarResposta(resposta);
			}
		}

	}

	@Override
	public void salvarResposta(List<Resposta> respostas) {
		RespostaEntity resposta = new RespostaEntity();
		resposta.setDataCadastro(Calendar.getInstance());
		resposta.setDataAlteracao(Calendar.getInstance());
		resposta.setDescricaoResposta(((RespostaEntity) respostas).getDescricaoResposta());
		resposta.setPerguntaEntity(parseService.parseToEntity(((Resposta) respostas).getPergunta()));
		resposta.setUsuarioEntity(parseService.parseToEntity(((Resposta) respostas).getUsuario()));
		resposta.setRespostaStatus(((RespostaEntity)respostas).getRespostaStatus());
		resposta.setReeducandoEntity(parseService.parseToEntity(((Resposta) respostas).getReeducando()));
		resposta.setProjetoEntity(parseService.parseToEntity(((Resposta) respostas).getProjeto()));
		respostaProjetoDAO.salvarResposta(resposta);

	}

}
