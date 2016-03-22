package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.TarefaProjeto;

public interface TarefaProjetoService {
	public void cadastrar(TarefaProjeto tarefa);

	public List<TarefaProjeto> listarTarefas(long idProjeto);

	public TarefaProjeto buscarTarefaPorId(long idTarefa);

	public void editar(TarefaProjeto tarefa);
}