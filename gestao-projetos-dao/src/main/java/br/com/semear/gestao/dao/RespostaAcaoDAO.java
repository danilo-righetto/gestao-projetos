package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.RespostaAcaoEntity;

public interface RespostaAcaoDAO {
	void salvarRespostaAcao(RespostaAcaoEntity resposta);
	
	void alterarRespostaAcao(RespostaAcaoEntity resposta);
	
	void removerRespostaAcao(RespostaAcaoEntity resposta);
	
	RespostaAcaoEntity buscarRespostaAcaoPorId(long IdResposta);
	
	List<RespostaAcaoEntity> listarRespostas();
	
	//void salvarAlternativa(AlternativaPerguntaEntity alternativa);
}
