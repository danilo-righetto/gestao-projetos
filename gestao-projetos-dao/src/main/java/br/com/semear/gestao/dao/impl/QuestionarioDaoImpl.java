package br.com.semear.gestao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.QuestionarioDAO;
import br.com.semear.gestao.dao.entity.QuestionarioEntity;
import br.com.semear.gestao.dao.entity.TipoPerguntaEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class QuestionarioDaoImpl implements QuestionarioDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void salvarQuestionario(QuestionarioEntity questionario) {
		em.persist(questionario);
	}

	@Override
	public QuestionarioEntity buscarQuestionarioPorIdProjeto(long idProjeto) {
		Query query = em.createQuery("select q from QuestionarioEntity q where q.projeto.id = :idProjeto");
		query.setParameter("idProjeto", idProjeto);
		if(!query.getResultList().isEmpty()){
			return (QuestionarioEntity) query.getResultList().get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionarioEntity> listarQuestionarios() {
		Query query = em.createQuery("select q from QuestionarioEntity q");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoPerguntaEntity> listarTiposDePerguntas() {
		Query query = em.createQuery("select tp from TipoPerguntaEntity tp");
		return query.getResultList();
	}

}
