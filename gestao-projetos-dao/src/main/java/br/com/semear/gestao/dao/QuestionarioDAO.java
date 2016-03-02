package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.QuestionarioEntity;
import br.com.semear.gestao.dao.entity.TipoPerguntaEntity;

public interface QuestionarioDAO {

	void salvarQuestionario(QuestionarioEntity questionario);

	QuestionarioEntity buscarQuestionarioPorIdProjeto(long idProjeto);

	List<QuestionarioEntity> listarQuestionarios();

	List<TipoPerguntaEntity> listarTiposDePerguntas();

}
