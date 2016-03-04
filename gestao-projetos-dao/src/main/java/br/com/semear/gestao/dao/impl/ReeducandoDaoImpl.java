package br.com.semear.gestao.dao.impl;

import java.util.List;

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
	public void editarReeducando(ReeducandoEntity reeducando) {
		em.merge(reeducando);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ReeducandoEntity> listarReeducandos() {
		Query query = em.createQuery("select r from ReeducandoEntity r");
		return query.getResultList();
	}

	@Override
	public ReeducandoEntity buscarReeducandoPorId(long idReeducando) {
		Query query = em.createQuery("select r from ReeducandoEntity r where r.id = :idReeducando");
		query.setParameter("idReeducando", idReeducando);
		return (ReeducandoEntity) query.getSingleResult();
	}

	@Override
	public ReeducandoEntity buscarMatricula(long matricula) {
		Query query = em.createQuery("select r from ReeducandoEntity r where r.matricula = :matricula");
		query.setParameter("matricula", String.valueOf(matricula));
		if(query.getResultList().isEmpty()){
			return null;
		}
		return (ReeducandoEntity)query.getSingleResult();
	}
}