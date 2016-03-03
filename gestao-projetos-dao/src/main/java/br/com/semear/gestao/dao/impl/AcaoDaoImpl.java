package br.com.semear.gestao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.AcaoDAO;
import br.com.semear.gestao.dao.entity.AcaoEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class AcaoDaoImpl implements AcaoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void cadastrar(AcaoEntity acao) {
		em.persist(acao);
	}

	@Override
	public void editar(AcaoEntity acao) {
		em.merge(acao);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AcaoEntity> listarAcoes() {
		Query query = em.createQuery("select a from AcaoEntity a");
		return query.getResultList();
	}

	@Override
	public AcaoEntity buscarAcaoPorId(long idAcao) {
		Query query = em.createQuery("select a from AcaoEntity a where a.id = :idAcao");
		query.setParameter("idAcao", idAcao);
		return (AcaoEntity) query.getSingleResult();
	}
}