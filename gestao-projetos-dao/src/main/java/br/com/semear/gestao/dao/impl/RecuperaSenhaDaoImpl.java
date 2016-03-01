package br.com.semear.gestao.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.RecuperaSenhaDAO;
import br.com.semear.gestao.dao.entity.RequisicaoSenhaEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class RecuperaSenhaDaoImpl implements RecuperaSenhaDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean possuiRequisicaoNovaSenha(String email) {
		Query query = entityManager.createQuery("select r from RequisicaoSenhaEntity as r where r.email = :paramEmail");
		query.setParameter("paramEmail", email);
		if (!query.getResultList().isEmpty()) {
			return true;
		}

		return false;
	}

	@Override
	public void inserirRequisicao(RequisicaoSenhaEntity nova) {
		entityManager.persist(nova);
	}

	@Override
	public RequisicaoSenhaEntity buscarUsuarioRedefinirSenha(String hash) {
		RequisicaoSenhaEntity requisicao = null;
		Query query = entityManager.createQuery("select r from RequisicaoSenhaEntity as r where r.hashUrl = :paramHash");
		query.setParameter("paramHash", hash);
		if (!query.getResultList().isEmpty()) {
			requisicao = (RequisicaoSenhaEntity) query.getResultList().get(0);
		}
		return requisicao;
	}

	@Override
	public void removerSolicitacao(RequisicaoSenhaEntity requisicao) {
		RequisicaoSenhaEntity requisicaoEntity = entityManager.merge(requisicao);
		entityManager.remove(requisicaoEntity);
	}

}