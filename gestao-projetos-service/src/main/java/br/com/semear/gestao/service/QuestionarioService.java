package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.dao.entity.ProjetoEntity;
import br.com.semear.gestao.model.Pergunta;
import br.com.semear.gestao.model.Questionario;
import br.com.semear.gestao.model.TipoPergunta;

public interface QuestionarioService {

	void criarQuestionarioProjeto(ProjetoEntity projeto);

	Questionario buscarQuestionarioPorIdProjeto(long idProjeto) throws Exception;

	List<Questionario> listarQuestionarios();

	List<TipoPergunta> listarTiposDePerguntas();

	String alterarQuestionario(Questionario questionario,	List<Pergunta> perguntasRemovidas);

	Pergunta buscarPerguntaPorIdProjetoEiDPergunta(long idProjeto,long idAcao);
}
