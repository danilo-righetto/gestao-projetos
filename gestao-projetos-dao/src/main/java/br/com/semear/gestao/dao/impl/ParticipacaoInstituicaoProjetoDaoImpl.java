package br.com.semear.gestao.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ParticipacaoInstituicaoProjetoDAO;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ParticipacaoInstituicaoProjetoDaoImpl implements ParticipacaoInstituicaoProjetoDAO {

	@PersistenceContext
	private EntityManager em;

	
}
