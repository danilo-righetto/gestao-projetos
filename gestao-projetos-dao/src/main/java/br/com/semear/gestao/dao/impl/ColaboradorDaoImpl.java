package br.com.semear.gestao.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ColaboradorDAO;
import br.com.semear.gestao.dao.entity.ColaboradorEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ColaboradorDaoImpl implements ColaboradorDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void cadastrar(ColaboradorEntity entity) {
		em.persist(entity);
	}

	@Override
	public void editar(ColaboradorEntity entity) {
		em.merge(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ColaboradorEntity> listarColaboradores(long idInstituicao) {
		Query query = em
				.createQuery("select c from ColaboradorEntity c where c.usuario.instituicao.id = :idInstituicao");
		query.setParameter("idInstituicao", idInstituicao);
		if (!query.getResultList().isEmpty()) {
			return query.getResultList();
		}
		return new ArrayList<ColaboradorEntity>();
	}

	@Override
	public ColaboradorEntity buscarColaboradorPorId(long idColaborador) {
		Query query = em.createQuery("select c from ColaboradorEntity c where c.id = :idColaborador");
		query.setParameter("idColaborador", idColaborador);
		return (ColaboradorEntity) query.getSingleResult();
	}

}
