package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.QuestionarioAcaoDAO;
import br.com.semear.gestao.dao.entity.AcaoEntity;
import br.com.semear.gestao.dao.entity.AlternativaPerguntaAcaoEntity;
import br.com.semear.gestao.dao.entity.PerguntaAcaoEntity;
import br.com.semear.gestao.dao.entity.QuestionarioAcaoEntity;
import br.com.semear.gestao.dao.entity.TipoPerguntaEntity;
import br.com.semear.gestao.model.Acao;
import br.com.semear.gestao.model.AlternativaPerguntaAcao;
import br.com.semear.gestao.model.PerguntaAcao;
import br.com.semear.gestao.model.QuestionarioAcao;
import br.com.semear.gestao.model.TipoPergunta;
import br.com.semear.gestao.service.AcaoService;
import br.com.semear.gestao.service.ParseService;
import br.com.semear.gestao.service.QuestionarioAcaoService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionarioAcaoServiceImpl implements QuestionarioAcaoService {
	
	@Inject
	private ParseService parseService;
	
	@Inject
	private QuestionarioAcaoDAO questionarioAcaoDAO;
	
	@Inject
	private AcaoService acaoService;

	@Override
	public void criarQuestionarioAcao(AcaoEntity acao) {
		QuestionarioAcaoEntity questionarioAcao = new QuestionarioAcaoEntity();
		questionarioAcao.setDataCadastro(Calendar.getInstance());
		questionarioAcao.setDescricao("QUESTIONARIO DA ACAO "+acao.getNome().toUpperCase());
		questionarioAcao.setAcao(acao);
		questionarioAcaoDAO.salvarQuestionario(questionarioAcao);
	}

	@Override
	public QuestionarioAcao buscarQuestionarioPorIdAcao(long idAcao) throws Exception {
		QuestionarioAcaoEntity entity = questionarioAcaoDAO.buscarQuestionarioPorIdAcao(idAcao);
				QuestionarioAcao questionario = null;
				if(entity != null){
					questionario = parseService.parseToModel(entity);
					questionario.setPerguntas(buscarPerguntasPorIdQuestionario(questionario.getId()));
				}else{
					Acao acao = acaoService.buscarAcaoPorId(idAcao);
					if(acao != null){
						criarQuestionarioAcao(parseService.parseToEntity(acao));
						questionario = buscarQuestionarioPorIdAcao(idAcao);
					}else{
						throw new Exception("ACAO INEXISTENTE - ID:"+idAcao);
					}
				}
				return questionario;
	}
	@Override
	public List<PerguntaAcao> buscarPerguntasPorIdQuestionario(long idQuestionario) {
		List<PerguntaAcaoEntity> entitys = questionarioAcaoDAO.buscarPerguntasPorIdQuestionario(idQuestionario);
		List<PerguntaAcao> perguntas = new ArrayList<PerguntaAcao>();
		for(PerguntaAcaoEntity p : entitys){
			p.setAlternativas(questionarioAcaoDAO.buscarAlternativasPorIdPergunta(p.getId()));
			PerguntaAcao pergunta = parseService.parseToModel(p);
			for(AlternativaPerguntaAcaoEntity a:p.getAlternativas()){
				pergunta.getAlternativas().add(parseService.parseToModel(a));
			}
			perguntas.add(pergunta);
		}
		return perguntas;
	}

	@Override
	public List<QuestionarioAcao> listarQuestionarios() {
		List<QuestionarioAcaoEntity> lista = questionarioAcaoDAO.listarQuestionarios();
				List<QuestionarioAcao> questionarios = new ArrayList<QuestionarioAcao>();
				for(QuestionarioAcaoEntity q: lista){
					questionarios.add(parseService.parseToModel(q));
				}
				return questionarios;
	}

	@Override
	public List<TipoPergunta> listarTiposDePerguntas() {
		List<TipoPerguntaEntity> lista = questionarioAcaoDAO.listarTiposDePerguntas();
		List<TipoPergunta> tipos = new ArrayList<TipoPergunta>();
		for(TipoPerguntaEntity t: lista){
			tipos.add(parseService.parseToModel(t));
		}
		return tipos;
	}

	@Override
	public void alterarQuestionario(QuestionarioAcao questionario, List<PerguntaAcao> perguntasRemovidas) {
		removerPerguntas(perguntasRemovidas);
		adicionarPerguntas(questionario);
		
	}

	private void removerPerguntas(List<PerguntaAcao> perguntasRemovidas) {
		for(PerguntaAcao p : perguntasRemovidas){
			if(p.getId() != 0){
				PerguntaAcaoEntity perguntaAcaoEntity = questionarioAcaoDAO.buscarPerguntasPorId(p.getId());
				removerAlternativas(perguntaAcaoEntity);
				questionarioAcaoDAO.removerPergunta(perguntaAcaoEntity);
				
			}
		}
		
	}
	
	private void removerAlternativas(PerguntaAcaoEntity perguntaAcaoEntity){
		questionarioAcaoDAO.removerAlternativasPorIdPergunta(perguntaAcaoEntity.getId());
	}

	private void adicionarPerguntas(QuestionarioAcao questionario) {
		for(PerguntaAcao p : questionario.getPerguntas()){
			PerguntaAcaoEntity perguntaAcaoEntity = parseService.parseToEntity(p);
			
			for(AlternativaPerguntaAcao alternativa : p.getAlternativas()){
				perguntaAcaoEntity.getAlternativas().add(parseService.parseToEntity(alternativa));
			}

			if(perguntaAcaoEntity.getId() != 0){
				questionarioAcaoDAO.alterarPergunta(perguntaAcaoEntity);
			}else{
				questionarioAcaoDAO.salvarPergunta(perguntaAcaoEntity);
				adicionarAlternativas(perguntaAcaoEntity);
			}
			
		}
		
	}
	
	private void adicionarAlternativas(PerguntaAcaoEntity perguntaAcaoEntity){
		for(AlternativaPerguntaAcaoEntity alternativa : perguntaAcaoEntity.getAlternativas()){
			alternativa.setDataCadastro(Calendar.getInstance());
			alternativa.setPerguntaAcaoEntity(perguntaAcaoEntity);
			questionarioAcaoDAO.salvarAlternativa(alternativa);
		}
	}

	@Override
	public PerguntaAcao buscarPerguntaPorIdAcaoEiDPergunta(int idPergunta,Long idAcao) {
		PerguntaAcao pergunta = parseService.parseToModel(questionarioAcaoDAO.buscarPerguntaPorIdAcaoEiDPergunta(idPergunta,idAcao));
		return pergunta;
	}

}
