package br.com.semear.gestao.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public void cadastrarInstituicao(InstituicaoEntity instituicao) {
		em.persist(instituicao);
		
	}

}
