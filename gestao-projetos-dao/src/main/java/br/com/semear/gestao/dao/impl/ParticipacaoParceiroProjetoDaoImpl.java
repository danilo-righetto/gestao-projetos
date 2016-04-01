package br.com.semear.gestao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ParticipacaoParceiroProjetoDAO;
import br.com.semear.gestao.dao.entity.ParticipacaoParceiroProjetoEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ParticipacaoParceiroProjetoDaoImpl implements ParticipacaoParceiroProjetoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void cadastrarParticipacaoParceiro(ParticipacaoParceiroProjetoEntity entity) {
		em.persist(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ParticipacaoParceiroProjetoEntity> listarParticipacaoParceirosProjeto(long idProjeto) {
		Query query = em
				.createQuery("select p from ParticipacaoParceiroProjetoEntity p where p.projeto.id = :idProjeto");
		query.setParameter("idProjeto", idProjeto);

		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Long> buscarParceirosAssociados(long idProjeto) {
		Query query = em.createQuery(
				"select p.parceiro.id from ParticipacaoParceiroProjetoEntity p where p.projeto.id = :idProjeto");
		query.setParameter("idProjeto", idProjeto);
		return query.getResultList();
	}

	@Override
	public ParticipacaoParceiroProjetoEntity buscarParticipacaoPorProjetoEParceiro(Long idProjeto, Long idParceiro) {
		Query query = em.createQuery(
				"select p from ParticipacaoParceiroProjetoEntity p where p.projeto.id = :idProjeto and " +
				"p.parceiro.id = :idParceiro");
		query.setParameter("idProjeto", idProjeto);
		query.setParameter("idParceiro", idParceiro);
		if(!query.getResultList().isEmpty()){
			return (ParticipacaoParceiroProjetoEntity) query.getResultList().get(0);
		}
		return null;
	}
}