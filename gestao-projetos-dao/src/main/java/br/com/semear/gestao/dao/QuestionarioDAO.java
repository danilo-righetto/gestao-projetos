package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.AlternativaPerguntaEntity;
import br.com.semear.gestao.dao.entity.PerguntaEntity;
import br.com.semear.gestao.dao.entity.QuestionarioEntity;
import br.com.semear.gestao.dao.entity.TipoPerguntaEntity;

public interface QuestionarioDAO {

	void salvarQuestionario(QuestionarioEntity questionario);

	QuestionarioEntity buscarQuestionarioPorIdProjeto(long idProjeto);

	List<QuestionarioEntity> listarQuestionarios();

	List<TipoPerguntaEntity> listarTiposDePerguntas();

	void alterarQuestionario(QuestionarioEntity entity);

	void salvarPergunta(PerguntaEntity entity);

	List<PerguntaEntity> buscarPerguntasPorIdQuestionario(long idQuestionario);

	void removerPergunta(PerguntaEntity perguntaEntity);

	void alterarPergunta(PerguntaEntity perguntaEntity);

	PerguntaEntity buscarPerguntasPorId(long id);

	void salvarAlternativa(AlternativaPerguntaEntity alternativa);
	
	void removerAlternativasPorIdPergunta(long idPergunta);
	
	List<AlternativaPerguntaEntity> buscarAlternativasPorIdPergunta(long id);
	
	PerguntaEntity buscarPerguntaPorIdProjetoEiDPergunta(long idProjeto,long idAcao);

}
