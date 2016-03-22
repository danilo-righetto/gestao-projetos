package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.RespostaEntity;

public interface RespostaProjetoDAO {
	void salvarResposta(RespostaEntity resposta);
	
	void alterarResposta(RespostaEntity resposta);
	
	void removerResposta(RespostaEntity resposta);
	
	RespostaEntity buscarRespostaProjetoPorId(long IdResposta);
	
	List<RespostaEntity> listarRespostas();
}
