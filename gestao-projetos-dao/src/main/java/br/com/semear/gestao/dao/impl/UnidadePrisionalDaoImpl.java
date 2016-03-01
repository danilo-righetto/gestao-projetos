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
	@SuppressWarnings("unchecked")
	public List<UnidadePrisionalEntity> listarUnidades() {
		Query query = em.createQuery("select up from UnidadePrisionalEntity up");
		return query.getResultList();
	}
}