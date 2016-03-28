package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.TarefaProjetoDAO;
import br.com.semear.gestao.dao.entity.TarefaProjetoEntity;
import br.com.semear.gestao.model.TarefaProjeto;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.ParseService;
import br.com.semear.gestao.service.TarefaProjetoService;
import br.com.semear.gestao.service.UsuarioService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TarefaProjetoServiceImpl implements TarefaProjetoService {

	@Inject
	private TarefaProjetoDAO tarefaProjetoDAO;

	@Inject
	private ParseService parse;

	@Inject
	private UsuarioService usuarioService;

	@Override
	public void cadastrar(TarefaProjeto tarefa) {
		Usuario autor = usuarioService.buscarUsuarioPorId(tarefa.getAutor().getId());
		Usuario responsavel = usuarioService.buscarUsuarioPorId(tarefa.getResponsavel().getId());

		tarefa.setAutor(autor);
		tarefa.setStatus("Aberto");
		tarefa.setResponsavel(responsavel);
		tarefa.setDataCadastro(Calendar.getInstance());

		tarefaProjetoDAO.cadastrar(parse.parseToEntity(tarefa));
	}

	@Override
	public List<TarefaProjeto> listarTarefas(long idProjeto) {
		List<TarefaProjetoEntity> lista = tarefaProjetoDAO.listarTarefasProjeto(idProjeto);
		List<TarefaProjeto> tarefas = new ArrayList<TarefaProjeto>();
		for (TarefaProjetoEntity tarefa : lista) {
			tarefas.add(parse.parseToModel(tarefa));
		}
		return tarefas;
	}

	@Override
	public TarefaProjeto buscarTarefaPorId(long idTarefa) {
		return parse.parseToModel(tarefaProjetoDAO.buscarTarefaPorId(idTarefa));
	}

	@Override
	public void editar(TarefaProjeto tarefa) {
		TarefaProjetoEntity entity = tarefaProjetoDAO.buscarTarefaPorId(tarefa.getId());
		if(entity != null){
			Usuario responsavel = usuarioService.buscarUsuarioPorId(tarefa.getResponsavel().getId());
			entity.setDataInicio(tarefa.getDataInicio());
			entity.setDescricao(tarefa.getDescricao());
			entity.setPrevisaoTermino(tarefa.getPrevisaoTermino());
			entity.setResponsavel(parse.parseToEntity(responsavel));
			tarefaProjetoDAO.editar(entity);
		}
	}

	@Override
	public TarefaProjeto concluirTarefa(long idTarefa) {
		TarefaProjetoEntity entity = tarefaProjetoDAO.buscarTarefaPorId(idTarefa);
		TarefaProjeto tarefa = null;
		if(entity != null){
			entity.setDataTermino(Calendar.getInstance());
			entity.setStatus("Concluido");
			tarefaProjetoDAO.editar(entity);
			tarefa = parse.parseToModel(entity);
		}else{
			tarefa = new TarefaProjeto();
		}
		return tarefa;
	}
}