package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.InformacaoProjeto;
import br.com.semear.gestao.model.Projeto;
import br.com.semear.gestao.model.Usuario;

public interface ProjetoService {
	public String cadastrarProjeto(Projeto projeto);

	public List<Projeto> listarTodosProjetos();

	public Projeto buscarProjetoPorNome(String nome);

	public Projeto buscarProjetoPorId(long idProjeto);

	public void editarProjeto(Projeto projeto);
	
	public long buscarUnidadePrisionalDoProjeto(long idProjeto);

	public Usuario buscarCoordenadorPorIdProjeto(long idProjeto);
	
	public void adicionarVinculoAcaoComProjeto(long idAcao, long idProjeto);

	public void cadastrarInformacoesAdicionais(InformacaoProjeto informacaoProjeto);

	public InformacaoProjeto buscarInformacaoProjetoPorIdProjeto(Long idProjeto);

	public List<Integer> calcularProgresso(List<Projeto> projetos);
}