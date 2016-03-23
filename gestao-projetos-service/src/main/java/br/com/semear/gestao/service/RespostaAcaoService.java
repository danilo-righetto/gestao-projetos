package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.RespostaAcao;
import br.com.semear.gestao.model.Usuario;

public interface RespostaAcaoService {
	void alterarRespostaAcao(RespostaAcao resposta);
	
	void removerRespostaAcao(RespostaAcao resposta);
	
	RespostaAcao buscarRespostaAcaoPorId(long IdResposta);
	
	List<RespostaAcao> listarRespostas();

	void salvarRespostaAcao(String[] respostas, Long idAcao, Usuario usuario);

	void salvarRespostaAcao(List<RespostaAcao> respostas);
}
