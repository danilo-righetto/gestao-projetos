package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.AlternativaPerguntaAcaoEntity;
import br.com.semear.gestao.dao.entity.PerguntaAcaoEntity;
import br.com.semear.gestao.dao.entity.QuestionarioAcaoEntity;
import br.com.semear.gestao.dao.entity.TipoPerguntaEntity;

public interface QuestionarioAcaoDAO {
	void salvarQuestionario(QuestionarioAcaoEntity questionario);

	QuestionarioAcaoEntity buscarQuestionarioPorIdAcao(long idAcao);

	List<QuestionarioAcaoEntity> listarQuestionarios();

	List<TipoPerguntaEntity> listarTiposDePerguntas();

	void alterarQuestionario(QuestionarioAcaoEntity entity);

	void salvarPergunta(PerguntaAcaoEntity entity);

	List<PerguntaAcaoEntity> buscarPerguntasPorIdQuestionario(long idQuestionario);

	void removerPergunta(PerguntaAcaoEntity perguntaAcaoEntity);

	void alterarPergunta(PerguntaAcaoEntity perguntaAcaoEntity);

	PerguntaAcaoEntity buscarPerguntasPorId(long id);

	void salvarAlternativa(AlternativaPerguntaAcaoEntity alternativa);
	
	void removerAlternativasPorIdPergunta(long id);

	List<AlternativaPerguntaAcaoEntity> buscarAlternativasPorIdPergunta(long id);

	PerguntaAcaoEntity buscarPerguntaPorIdAcaoEiDPergunta(long idPergunta,long idAcao);
}
