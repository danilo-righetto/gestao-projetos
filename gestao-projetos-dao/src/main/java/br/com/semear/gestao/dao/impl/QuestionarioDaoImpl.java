package br.com.semear.gestao.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.QuestionarioDAO;
import br.com.semear.gestao.dao.entity.AlternativaPerguntaEntity;
import br.com.semear.gestao.dao.entity.PerguntaEntity;
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

	@Override
	public void alterarQuestionario(QuestionarioEntity entity) {
		em.merge(entity);
		
	}

	@Override
	public void salvarPergunta(PerguntaEntity entity) {
		em.persist(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PerguntaEntity> buscarPerguntasPorIdQuestionario(long idQuestionario) {
		Query query = em.createQuery("select p from PerguntaEntity p where p.questionarioEntity.id = :idQuestionario");
		query.setParameter("idQuestionario", idQuestionario);
		if(!query.getResultList().isEmpty()){
			return query.getResultList();
		}
		return new ArrayList<PerguntaEntity>();
	}

	@Override
	public void removerPergunta(PerguntaEntity perguntaEntity) {
		em.remove(perguntaEntity);
	}

	@Override
	public void alterarPergunta(PerguntaEntity perguntaEntity) {
		em.merge(perguntaEntity);		
	}

	@Override
	public PerguntaEntity buscarPerguntasPorId(long id) {
		Query query = em.createQuery("select p from PerguntaEntity p where p.id = :id");
		query.setParameter("id", id);
		if(!query.getResultList().isEmpty()){
			return (PerguntaEntity) query.getResultList().get(0);
		}
		return null;
	}

	@Override
	public void salvarAlternativa(AlternativaPerguntaEntity alternativa) {
		
		em.persist(alternativa);
		
	}

	@Override
	public void removerAlternativasPorIdPergunta(long idPergunta) {
		Query query = em.createNativeQuery("delete from ALTERNATIVA_PERGUNTA where PERGUNTA = :idPergunta");
		
		query.setParameter("idPergunta",idPergunta);
		
		query.executeUpdate();		
	}

	@Override
	public PerguntaEntity buscarPerguntaPorIdProjetoEiDPergunta(long idProjeto, long idPergunta) {
		Query query = em.createQuery("select p from PerguntaEntity p where p.id = :idPergunta and p.questionarioEntity.projeto.id = :idProjeto");
		query.setParameter("idPergunta", idPergunta);
		query.setParameter("idProjeto", idProjeto);
		if(!query.getResultList().isEmpty()){
			return (PerguntaEntity) query.getResultList().get(0);
		}
		return new PerguntaEntity();
	}

}
