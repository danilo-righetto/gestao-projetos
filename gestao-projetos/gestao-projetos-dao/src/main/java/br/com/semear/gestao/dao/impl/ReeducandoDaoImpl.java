package br.com.semear.gestao.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ReeducandoDAO;
import br.com.semear.gestao.dao.entity.ReeducandoEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ReeducandoDaoImpl implements ReeducandoDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void cadastrarReeducando(ReeducandoEntity reeducando) {
		em.persist(reeducando);
	}
	
	@Override
	public ReeducandoEntity buscarReeducandoPorId(long idReeducando){
		Query query = em.createQuery("select r from ReeducandoEntity r where r.id = :idReeducando");
		query.setParameter("idReeducando", idReeducando);
		return (ReeducandoEntity) query.getSingleResult();
	}

}
