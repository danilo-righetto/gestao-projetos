package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.QuestionarioDAO;
import br.com.semear.gestao.dao.entity.AlternativaPerguntaEntity;
import br.com.semear.gestao.dao.entity.PerguntaEntity;
import br.com.semear.gestao.dao.entity.ProjetoEntity;
import br.com.semear.gestao.dao.entity.QuestionarioEntity;
import br.com.semear.gestao.dao.entity.TipoPerguntaEntity;
import br.com.semear.gestao.model.AlternativaPergunta;
import br.com.semear.gestao.model.Pergunta;
import br.com.semear.gestao.model.Projeto;
import br.com.semear.gestao.model.Questionario;
import br.com.semear.gestao.model.TipoPergunta;
import br.com.semear.gestao.service.ParseService;
import br.com.semear.gestao.service.ProjetoService;
import br.com.semear.gestao.service.QuestionarioService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionarioServiceImpl implements QuestionarioService {
	
	@Inject
	private QuestionarioDAO questionarioDAO;
	
	@Inject
	private ProjetoService projetoService;
	
	@Inject
	private ParseService parseService;

	@Override
	public void criarQuestionarioProjeto(ProjetoEntity projeto) {
		QuestionarioEntity questionario = new QuestionarioEntity();
		questionario.setDataCadastro(Calendar.getInstance());
		questionario.setDescricao("QUESTIONÁRIO DO PROJETO "+projeto.getNome().toUpperCase());
		questionario.setProjeto(projeto);
		questionarioDAO.salvarQuestionario(questionario);
	}

	@Override
	public Questionario buscarQuestionarioPorIdProjeto(long idProjeto) throws Exception {
		QuestionarioEntity entity = questionarioDAO.buscarQuestionarioPorIdProjeto(idProjeto);
		Questionario questionario = null;
		if(entity != null){
			questionario = parseService.parseToModel(entity);
			questionario.setPerguntas(buscarPerguntasPorIdQuestionario(questionario.getId()));
		}else{
			Projeto projeto = projetoService.buscarProjetoPorId(idProjeto);
			if(projeto != null){
				criarQuestionarioProjeto(parseService.parseToEntity(projeto));
				questionario = buscarQuestionarioPorIdProjeto(idProjeto);
			}else{
				throw new Exception("PROJETO INEXISTENTE - ID:"+idProjeto);
			}
		}
		return questionario;
	}

	private List<Pergunta> buscarPerguntasPorIdQuestionario(long idQuestionario) {
		List<PerguntaEntity> entitys = questionarioDAO.buscarPerguntasPorIdQuestionario(idQuestionario);
		List<Pergunta> perguntas = new ArrayList<Pergunta>();
		for(PerguntaEntity p : entitys){
			p.setAlternativas(questionarioDAO.buscarAlternativasPorIdPergunta(p.getId()));
			Pergunta pergunta = parseService.parseToModel(p);
			for(AlternativaPerguntaEntity a:p.getAlternativas()){
				pergunta.getAlternativas().add(parseService.parseToModel(a));
			}
			//perguntas.add(parseService.parseToModel(p));
			perguntas.add(pergunta);
		}
		return perguntas;
	}

	@Override
	public List<Questionario> listarQuestionarios() {
		List<QuestionarioEntity> lista = questionarioDAO.listarQuestionarios();
		List<Questionario> questionarios = new ArrayList<Questionario>();
		for(QuestionarioEntity q: lista){
			questionarios.add(parseService.parseToModel(q));
		}
		return questionarios;
	}

	@Override
	public List<TipoPergunta> listarTiposDePerguntas() {
		List<TipoPerguntaEntity> lista = questionarioDAO.listarTiposDePerguntas();
		List<TipoPergunta> tipos = new ArrayList<TipoPergunta>();
		for(TipoPerguntaEntity t: lista){
			tipos.add(parseService.parseToModel(t));
		}
		return tipos;
	}

	@Override
	public String alterarQuestionario(Questionario questionario,List<Pergunta> perguntasRemovidas) {
		String msg = null;
		try {
			removerPerguntas(perguntasRemovidas);
			adicionarPerguntas(questionario);
			msg = "OK";
		} catch (Exception e) {
			msg = "NOK";
		}
		return msg;
	}

	private void adicionarPerguntas(Questionario questionario) {
		for(Pergunta p : questionario.getPerguntas()){
			PerguntaEntity perguntaEntity = parseService.parseToEntity(p);
			
			for(AlternativaPergunta alternativa : p.getAlternativas()){
				perguntaEntity.getAlternativas().add(parseService.parseToEntity(alternativa));
			}

			if(perguntaEntity.getId() != 0){
				questionarioDAO.alterarPergunta(perguntaEntity);
			}else{
				questionarioDAO.salvarPergunta(perguntaEntity);
				adicionarAlternativas(perguntaEntity);
			}
			
		}
		
	}

	private void adicionarAlternativas(PerguntaEntity perguntaEntity) {
		for(AlternativaPerguntaEntity alternativa : perguntaEntity.getAlternativas()){
			alternativa.setDataCadastro(Calendar.getInstance());
			alternativa.setPerguntaEntity(perguntaEntity);
			questionarioDAO.salvarAlternativa(alternativa);
		}
	}

	private void removerPerguntas(List<Pergunta> perguntasRemovidas) {
		for(Pergunta p : perguntasRemovidas){
			if(p.getId() != 0){
				PerguntaEntity perguntaEntity = questionarioDAO.buscarPerguntasPorId(p.getId());
				removerAlternativas(perguntaEntity);
				questionarioDAO.removerPergunta(perguntaEntity);
				
			}
		}
	}
	
	private void removerAlternativas(PerguntaEntity perguntaEntity) {
		questionarioDAO.removerAlternativasPorIdPergunta(perguntaEntity.getId());
	}

	@Override
	public Pergunta buscarPerguntaPorIdProjetoEiDPergunta(long idProjeto, long idPergunta) {
		Pergunta pergunta = parseService.parseToModel(questionarioDAO.buscarPerguntaPorIdProjetoEiDPergunta(idPergunta,idProjeto));
		return pergunta;
	}

}
