package br.com.semear.gestao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.UnidadePrisionalDAO;
import br.com.semear.gestao.dao.entity.UnidadePrisionalEntity;
import br.com.semear.gestao.dao.entity.UnidadeRelParceiroEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class UnidadePrisionalDaoImpl implements UnidadePrisionalDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void cadastrar(UnidadePrisionalEntity unidadePrisional) {
		em.persist(unidadePrisional);
	}

	@Override
	public void editar(UnidadePrisionalEntity unidadePrisional) {
		em.merge(unidadePrisional);
	}

	@Override
	public void excluir(UnidadePrisionalEntity unidadePrisional) {
		em.remove(unidadePrisional);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UnidadePrisionalEntity> listarUnidades() {
		Query query = em.createQuery("select up from UnidadePrisionalEntity up");
		return query.getResultList();
	}

	@Override
	public UnidadePrisionalEntity buscarUnidadePrisionalPorId(long idUnidadePrisional) {
		Query query = em.createQuery("select u from UnidadePrisionalEntity u where u.id = :idUnidadePrisional");
		query.setParameter("idUnidadePrisional", idUnidadePrisional);
		return (UnidadePrisionalEntity) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UnidadePrisionalEntity> buscarUnidadePrisionalPorParceiro(long idParceiro) {
		Query query = em.createQuery("select u.unidadePrisional from UnidadeRelParceiroEntity u where u.parceiro.id = :idParceiro");
		query.setParameter("idParceiro", idParceiro);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UnidadePrisionalEntity> listarUnidadesPorStatus(boolean status) {
		Query query = em.createQuery("select up from UnidadePrisionalEntity up where up.status = :status");
		query.setParameter("status", status);
		return query.getResultList();
	}

	@Override
	public void adicionarVinculoParceiroComUnidadePrisional(UnidadeRelParceiroEntity rel) {
		em.persist(rel);
	}
}