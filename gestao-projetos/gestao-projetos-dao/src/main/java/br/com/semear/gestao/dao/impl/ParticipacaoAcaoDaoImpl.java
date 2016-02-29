package br.com.semear.gestao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ParticipacaoAcaoDAO;
import br.com.semear.gestao.dao.entity.ParticipacaoAcaoEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ParticipacaoAcaoDaoImpl implements ParticipacaoAcaoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void cadastrar(ParticipacaoAcaoEntity participacaoAcao) {
		em.persist(participacaoAcao);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ParticipacaoAcaoEntity> listarParticipacaoAcoes() {
		Query query = em.createQuery("select pa from ParticipacaoAcaoEntity pa");
		return query.getResultList();
	}
}