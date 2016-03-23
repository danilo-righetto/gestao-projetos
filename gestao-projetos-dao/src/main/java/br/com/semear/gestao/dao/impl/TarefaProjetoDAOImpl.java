package br.com.semear.gestao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.TarefaProjetoDAO;
import br.com.semear.gestao.dao.entity.TarefaProjetoEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class TarefaProjetoDAOImpl implements TarefaProjetoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void cadastrar(TarefaProjetoEntity tarefa) {
		em.persist(tarefa);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TarefaProjetoEntity> listarTarefasProjeto(long idProjeto) {
		Query query = em.createQuery("select t from TarefaProjetoEntity t where t.projeto.id = :idProjeto");
		query.setParameter("idProjeto", idProjeto);
		if (!query.getResultList().isEmpty()) {
			return query.getResultList();
		}
		return null;
	}

	@Override
	public TarefaProjetoEntity buscarTarefaPorId(long idTarefa) {
		Query query = em.createQuery("select t from TarefaProjetoEntity t where t.id = :idTarefa");
		query.setParameter("idTarefa", idTarefa);
		if(!query.getResultList().isEmpty()){
			return (TarefaProjetoEntity) query.getSingleResult();
		}
		return null;
	}

	@Override
	public void editar(TarefaProjetoEntity tarefa) {
		em.merge(tarefa);
	}
}