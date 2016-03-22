package br.com.semear.gestao.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.InformacaoProjetoDAO;
import br.com.semear.gestao.dao.entity.InformacaoProjetoEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class InformacaoProjetoDaoImpl implements InformacaoProjetoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void cadastrar(InformacaoProjetoEntity entity) {
		em.merge(entity);
	}

	@Override
	public InformacaoProjetoEntity buscarInformacaoProjetoPorIdProjeto(Long idProjeto) {
		Query query = em.createQuery("select i from InformacaoProjetoEntity i where i.projeto.id = :idProjeto");
		query.setParameter("idProjeto", idProjeto);
		if(!query.getResultList().isEmpty()){
			return (InformacaoProjetoEntity) query.getSingleResult();
		}
		return new InformacaoProjetoEntity();
	}
}
