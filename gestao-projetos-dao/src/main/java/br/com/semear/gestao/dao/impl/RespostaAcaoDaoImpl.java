package br.com.semear.gestao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.RespostaAcaoDAO;
import br.com.semear.gestao.dao.entity.RespostaAcaoEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class RespostaAcaoDaoImpl implements RespostaAcaoDAO{
	@PersistenceContext
	private EntityManager em;

	@Override
	public void salvarRespostaAcao(RespostaAcaoEntity resposta) {
		em.persist(resposta);
	}

	@Override
	public void alterarRespostaAcao(RespostaAcaoEntity resposta) {
		em.merge(resposta);
	}

	@Override
	public void removerRespostaAcao(RespostaAcaoEntity resposta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RespostaAcaoEntity buscarRespostaAcaoPorId(long IdResposta) {
		Query query = em.createQuery("select q from RespostaAcaoEntity q where q.acao.id = :IdResposta");
		query.setParameter("IdResposta", IdResposta);
		if(!query.getResultList().isEmpty()){
			return (RespostaAcaoEntity) query.getResultList().get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RespostaAcaoEntity> listarRespostas() {
		Query query = em.createQuery("select q from RespostaAcaoEntity q");
		return query.getResultList();
	}

}
