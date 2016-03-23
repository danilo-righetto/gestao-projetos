package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.TarefaProjetoEntity;

public interface TarefaProjetoDAO {
	public void cadastrar(TarefaProjetoEntity tarefaProjetoEntity);
	
	public List<TarefaProjetoEntity> listarTarefasProjeto(long idProjeto);

	public TarefaProjetoEntity buscarTarefaPorId(long idTarefa);

	public void editar(TarefaProjetoEntity tarefa);
}