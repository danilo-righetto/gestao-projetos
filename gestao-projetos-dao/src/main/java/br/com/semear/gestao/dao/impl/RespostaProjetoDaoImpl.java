package br.com.semear.gestao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.RespostaProjetoDAO;
import br.com.semear.gestao.dao.entity.RespostaEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class RespostaProjetoDaoImpl implements RespostaProjetoDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void salvarResposta(RespostaEntity resposta) {
		em.persist(resposta);
	}

	@Override
	public void alterarResposta(RespostaEntity resposta) {
		em.merge(resposta);
	}

	@Override
	public void removerResposta(RespostaEntity resposta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RespostaEntity buscarRespostaProjetoPorId(long IdResposta) {
		Query query = em.createQuery("select q from RespostaEntity q where q.projeto.id = :IdResposta");
		query.setParameter("IdResposta", IdResposta);
		if(!query.getResultList().isEmpty()){
			return (RespostaEntity) query.getResultList().get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RespostaEntity> listarRespostas() {
		Query query = em.createQuery("select q from RespostaEntity q");
		return query.getResultList();
	}
	
}
