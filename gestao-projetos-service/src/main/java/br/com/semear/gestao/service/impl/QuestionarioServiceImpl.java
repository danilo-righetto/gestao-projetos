package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.QuestionarioDAO;
import br.com.semear.gestao.dao.entity.ProjetoEntity;
import br.com.semear.gestao.dao.entity.QuestionarioEntity;
import br.com.semear.gestao.dao.entity.TipoPerguntaEntity;
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

}
