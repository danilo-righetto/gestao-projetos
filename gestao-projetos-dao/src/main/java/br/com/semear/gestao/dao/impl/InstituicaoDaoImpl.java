package br.com.semear.gestao.dao.impl;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.InstituicaoDAO;
import br.com.semear.gestao.dao.entity.InstituicaoEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class InstituicaoDaoImpl implements InstituicaoDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public long cadastrarInstituicao(InstituicaoEntity instituicao) {
		em.persist(instituicao);
		return instituicao.getId();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<InstituicaoEntity> listarInstituicoes() {
		Query query = em.createQuery("select u from InstituicaoEntity u");
		return query.getResultList();
	}

	@Override
	public void editarInstituicao(InstituicaoEntity entity) {
		InstituicaoEntity instituicao = entity;
		em.merge(instituicao);
	}

	@Override
	public InstituicaoEntity buscarInstituicaoPorId(Long idInstituicao) {
		Query query = em.createQuery("select u from InstituicaoEntity u where u.id = :idInstituicao");
		query.setParameter("idInstituicao", idInstituicao);
		if (!query.getResultList().isEmpty()) {
			return (InstituicaoEntity) query.getSingleResult();
		}
		return null;
	}

	@Override
	public InstituicaoEntity buscarInstituicaoPorDocumento(String documento) {
		Query query = em.createQuery("select u from InstituicaoEntity u where u.documento = :documento");
		query.setParameter("documento", documento);
		if (!query.getResultList().isEmpty()) {
			return (InstituicaoEntity) query.getSingleResult();
		}
		return null;
	}

	@Override
	public long buscarUnidadePrisionalPorInstituicao(long idInstituicao) {
		Query query = em
				.createQuery("select i.unidadePrisional.id from InstituicaoEntity i where i.id = :idInstituicao");
		query.setParameter("idInstituicao", idInstituicao);
		if (!query.getResultList().isEmpty()) {
			return (Long) query.getSingleResult();
		}
		return 0;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<InstituicaoEntity> buscarInstituicaoPorUnidade(long idUnidadePrisional) {
		Query query = em.createQuery(
				"select i from InstituicaoEntity i where i.status = 'ATIVO' and i.unidadePrisional.id = :idUnidadePrisional");
		query.setParameter("idUnidadePrisional", idUnidadePrisional);
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<InstituicaoEntity> buscarInstituicaoPorId(Long[] idInstituicoes) {
		Query query = em.createQuery("select i from InstituicaoEntity i where i.status = 'ATIVO' and i.id in(:idInstituicoes)");
		query.setParameter("idInstituicoes", Arrays.asList(idInstituicoes));
		return query.getResultList();
	}
}