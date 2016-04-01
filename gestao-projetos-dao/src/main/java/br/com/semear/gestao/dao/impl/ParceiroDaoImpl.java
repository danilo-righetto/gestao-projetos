package br.com.semear.gestao.dao.impl;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ParceiroDAO;
import br.com.semear.gestao.dao.entity.ParceiroEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ParceiroDaoImpl implements ParceiroDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public long cadastrarParceiro(ParceiroEntity parceiro) {
		em.persist(parceiro);
		return parceiro.getId();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ParceiroEntity> listarParceiros() {
		Query query = em.createQuery("select p from ParceiroEntity p");
		return query.getResultList();
	}

	@Override
	public void editarParceiro(ParceiroEntity entity) {
		ParceiroEntity parceiro = entity;
		em.merge(parceiro);
	}

	@Override
	public ParceiroEntity buscarParceiroPorId(Long idParceiro) {
		Query query = em.createQuery("select u from ParceiroEntity u where u.id = :idParceiro");
		query.setParameter("idParceiro", idParceiro);
		if (!query.getResultList().isEmpty()) {
			return (ParceiroEntity) query.getSingleResult();
		}
		return null;
	}

	@Override
	public ParceiroEntity buscarParceiroPorDocumento(String documento) {
		Query query = em.createQuery("select u from ParceiroEntity u where u.documento = :documento");
		query.setParameter("documento", documento);
		if (!query.getResultList().isEmpty()) {
			return (ParceiroEntity) query.getSingleResult();
		}
		return null;
	}

	@Override
	public long buscarUnidadePrisionalPorParceiro(long idParceiro) {
		Query query = em
				.createQuery("select i.unidadePrisional.id from ParceiroEntity i where i.id = :idParceiro");
		query.setParameter("idParceiro", idParceiro);
		if (!query.getResultList().isEmpty()) {
			return (Long) query.getSingleResult();
		}
		return 0;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ParceiroEntity> buscarParceiroPorUnidade(long idUnidadePrisional) {
		Query query = em.createQuery(
				"select u.parceiro from UnidadeRelParceiroEntity u where u.unidadePrisional.id = :idUnidadePrisional and u.parceiro.status = 'ATIVO'");
		query.setParameter("idUnidadePrisional", idUnidadePrisional);
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ParceiroEntity> buscarParceiroPorId(Long[] idParceiros) {
		Query query = em.createQuery("select i from ParceiroEntity i where i.status = 'ATIVO' and i.id in(:idParceiros)");
		query.setParameter("idParceiros", Arrays.asList(idParceiros));
		if(!query.getResultList().isEmpty()){
			return query.getResultList();
		}
		return null;
	}
}