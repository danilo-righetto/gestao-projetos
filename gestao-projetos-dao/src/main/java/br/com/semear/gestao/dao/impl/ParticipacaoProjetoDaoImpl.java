package br.com.semear.gestao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ParticipacaoProjetoDAO;
import br.com.semear.gestao.dao.entity.ParticipacaoReeducandoProjetoEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ParticipacaoProjetoDaoImpl implements ParticipacaoProjetoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void cadastrar(ParticipacaoReeducandoProjetoEntity participacaoProjeto) {
		em.persist(participacaoProjeto);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ParticipacaoReeducandoProjetoEntity> listarParticipacaoProjetos() {
		Query query = em.createQuery("select pp from ParticipacaoProjetoEntity pp");
		return query.getResultList();
	}
}