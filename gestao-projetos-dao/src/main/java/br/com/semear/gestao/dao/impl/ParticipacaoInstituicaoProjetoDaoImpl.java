package br.com.semear.gestao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ParticipacaoInstituicaoProjetoDAO;
import br.com.semear.gestao.dao.entity.ParticipacaoInstituicaoProjetoEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ParticipacaoInstituicaoProjetoDaoImpl implements ParticipacaoInstituicaoProjetoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void cadastrarParticipacaoInstituicao(ParticipacaoInstituicaoProjetoEntity entity) {
		long idProjeto = entity.getProjeto().getId();
		long idInstituicao = entity.getInstituicao().getId();
		Query query = em.createQuery(
				"select p from ParticipacaoInstituicaoProjetoEntity p where p.projeto.id = :idProjeto and p.instituicao.id = :idInstituicao");
		query.setParameter("idProjeto", idProjeto);
		query.setParameter("idInstituicao", idInstituicao);

		if (query.getResultList().isEmpty()) {
			em.persist(entity);
		} else {
			em.merge(entity);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ParticipacaoInstituicaoProjetoEntity> listarParticipacaoInstituicoesProjeto(long idProjeto) {
		Query query = em
				.createQuery("select p from ParticipacaoInstituicaoProjetoEntity p where p.projeto.id = :idProjeto");
		query.setParameter("idProjeto", idProjeto);
		if (!query.getResultList().isEmpty()) {
			return query.getResultList();
		}
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Long> buscarInstituicoesAssociadas(long idProjeto) {
		Query query = em.createQuery(
				"select p.instituicao.id from ParticipacaoInstituicaoProjetoEntity p where p.projeto.id = :idProjeto");
		query.setParameter("idProjeto", idProjeto);
		if (!query.getResultList().isEmpty()) {
			return query.getResultList();
		}
		return null;
	}
}