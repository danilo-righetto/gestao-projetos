package br.com.semear.gestao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ParticipacaoReeducandoProjetoDAO;
import br.com.semear.gestao.dao.entity.ParticipacaoReeducandoProjetoEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ParticipacaoReeducandoProjetoDaoImpl implements ParticipacaoReeducandoProjetoDAO {

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

	@SuppressWarnings("unchecked")
	@Override
	public List<ParticipacaoReeducandoProjetoEntity> listarParticipacaoProjetos(long idProjeto) {
		Query query = em.createQuery("select pp from ParticipacaoReeducandoProjetoEntity pp where pp.projeto.id = :idProjeto");
		query.setParameter("idProjeto",idProjeto);
		return query.getResultList();
	}
}