package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.dao.entity.AcaoEntity;
import br.com.semear.gestao.model.PerguntaAcao;
import br.com.semear.gestao.model.QuestionarioAcao;
import br.com.semear.gestao.model.TipoPergunta;

public interface QuestionarioAcaoService {
	void criarQuestionarioAcao(AcaoEntity acao);

	QuestionarioAcao buscarQuestionarioPorIdAcao(long idAcao) throws Exception;

	List<QuestionarioAcao> listarQuestionarios();

	List<TipoPergunta> listarTiposDePerguntas();

	void alterarQuestionario(QuestionarioAcao questionario,	List<PerguntaAcao> perguntasRemovidas);
}
