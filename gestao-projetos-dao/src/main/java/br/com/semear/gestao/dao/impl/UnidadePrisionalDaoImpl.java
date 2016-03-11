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
import br.com.semear.gestao.dao.entity.UnidadeRelInstituicaoEntity;

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
	public List<UnidadePrisionalEntity> buscarUnidadePrisionalPorInstituicao(long idInstituicao) {
		Query query = em.createQuery("select u.unidadePrisional from UnidadeRelInstituicaoEntity u where u.instituicao.id = :idInstituicao");
		query.setParameter("idInstituicao", idInstituicao);
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
	public void adicionarVinculoInstituicaoComUnidadePrisional(UnidadeRelInstituicaoEntity rel) {
		em.persist(rel);
	}
}