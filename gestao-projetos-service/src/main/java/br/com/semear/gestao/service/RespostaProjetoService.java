package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.Resposta;
import br.com.semear.gestao.model.Usuario;

public interface RespostaProjetoService {
	void alterarRespostaProjeto(Resposta resposta);
	
	void removerResposta(Resposta resposta);
	
	Resposta buscarRespostaProjetoPorId(long IdResposta);
	
	List<Resposta> listarRespostas();

	void salvarResposta(String[] respostas, Long idProjeto, Usuario usuario, Long reeducando, String tipo);

	void salvarResposta(List<Resposta> respostas);
	
	List<Resposta> listarRespostasReeducandoPorProjetoTipo(long idReeducando, Long idProjeto, String tipo);
}
