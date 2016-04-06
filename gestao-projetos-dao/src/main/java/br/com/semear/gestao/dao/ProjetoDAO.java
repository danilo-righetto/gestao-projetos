package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.AcaoRelProjetoEntity;
import br.com.semear.gestao.dao.entity.ParceiroEntity;
import br.com.semear.gestao.dao.entity.ProjetoEntity;
import br.com.semear.gestao.dao.entity.UsuarioEntity;

public interface ProjetoDAO {
	public long cadastrarProjeto(ProjetoEntity projeto);

	List<ProjetoEntity> listarTodosProjetos();

	ProjetoEntity buscarProjetoPorNome(String nome);

	public ProjetoEntity buscarProjetoPorId(long idProjeto);

	public void editarProjeto(ProjetoEntity entity);

	public long buscarUnidadePrisionalDoProjeto(long idProjeto);

	public UsuarioEntity buscarCoordenadorPorIdProjeto(long idProjeto);

	ParceiroEntity buscarParceiroDoCoodernadorPorIdProjeto(long idProjeto);
	
	public void adicionarVinculoAcaoComProjeto(AcaoRelProjetoEntity rel);
}