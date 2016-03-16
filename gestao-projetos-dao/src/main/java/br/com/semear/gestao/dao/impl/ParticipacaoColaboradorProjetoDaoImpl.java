package br.com.semear.gestao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ParticipacaoColaboradorProjetoDAO;
import br.com.semear.gestao.dao.entity.ParticipacaoColaboradorProjetoEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ParticipacaoColaboradorProjetoDaoImpl implements ParticipacaoColaboradorProjetoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void cadastrar(ParticipacaoColaboradorProjetoEntity entity) {
		em.persist(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ParticipacaoColaboradorProjetoEntity> listarParticipacaoProjetos(long idProjeto) {
		Query query = em.createQuery("select pp from ParticipacaoColaboradorProjetoEntity pp where pp.projeto.id = :idProjeto");
		query.setParameter("idProjeto",idProjeto);
		return query.getResultList();
	}
}