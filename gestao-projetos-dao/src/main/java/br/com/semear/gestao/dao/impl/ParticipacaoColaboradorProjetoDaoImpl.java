package br.com.semear.gestao.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ParticipacaoColaboradorProjetoDAO;
import br.com.semear.gestao.dao.entity.ParticipacaoColaboradorProjetoEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ParticipacaoColaboradorProjetoDaoImpl implements ParticipacaoColaboradorProjetoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void cadastrar(ParticipacaoColaboradorProjetoEntity entity) {
		em.persist(entity);
	}
}