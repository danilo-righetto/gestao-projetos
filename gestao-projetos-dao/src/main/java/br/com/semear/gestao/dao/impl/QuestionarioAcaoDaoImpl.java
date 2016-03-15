package br.com.semear.gestao.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.QuestionarioAcaoDAO;
import br.com.semear.gestao.dao.entity.AlternativaPerguntaAcaoEntity;
import br.com.semear.gestao.dao.entity.PerguntaAcaoEntity;
import br.com.semear.gestao.dao.entity.QuestionarioAcaoEntity;
import br.com.semear.gestao.dao.entity.TipoPerguntaEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class QuestionarioAcaoDaoImpl implements QuestionarioAcaoDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void salvarQuestionario(QuestionarioAcaoEntity questionario) {
		em.persist(questionario);
		
	}

	@Override
	public QuestionarioAcaoEntity buscarQuestionarioPorIdAcao(long idAcao) {
		Query query = em.createQuery("select q from QuestionarioAcaoEntity q where q.acao.id = :idAcao");
		query.setParameter("idAcao", idAcao);
		if(!query.getResultList().isEmpty()){
			return (QuestionarioAcaoEntity) query.getResultList().get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionarioAcaoEntity> listarQuestionarios() {
		Query query = em.createQuery("select q from QuestionarioAcaoEntity q");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoPerguntaEntity> listarTiposDePerguntas() {
		Query query = em.createQuery("select tp from TipoPerguntaEntity tp");
		return query.getResultList();
	}

	@Override
	public void alterarQuestionario(QuestionarioAcaoEntity entity) {
		em.merge(entity);
		
	}

	@Override
	public void salvarPergunta(PerguntaAcaoEntity entity) {
		em.persist(entity);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PerguntaAcaoEntity> buscarPerguntasPorIdQuestionario(long idQuestionario) {
		Query query = em.createQuery("select p from PerguntaAcaoEntity p where p.questionarioAcaoEntity.id = :idQuestionario");
		query.setParameter("idQuestionario", idQuestionario);
		if(!query.getResultList().isEmpty()){
			return query.getResultList();
		}
		return new ArrayList<PerguntaAcaoEntity>();
	}

	@Override
	public void removerPergunta(PerguntaAcaoEntity perguntaAcaoEntity) {
		em.remove(perguntaAcaoEntity);
		
	}

	@Override
	public void alterarPergunta(PerguntaAcaoEntity perguntaAcaoEntity) {
		em.merge(perguntaAcaoEntity);
		
	}

	@Override
	public PerguntaAcaoEntity buscarPerguntasPorId(long id) {
		Query query = em.createQuery("select p from PerguntaAcaoEntity p where p.id = :id");
		query.setParameter("id", id);
		if(!query.getResultList().isEmpty()){
			return (PerguntaAcaoEntity) query.getResultList().get(0);
		}
		return null;
	}

	@Override
	public void salvarAlternativa(AlternativaPerguntaAcaoEntity alternativa) {
		em.persist(alternativa);
		
	}

	@Override
	public void removerAlternativasPorIdPergunta(long idPergunta) {
		Query query = em.createNativeQuery("delete from ALTERNATIVA_PERGUNTA_ACAO where PERGUNTA_ACAO = :idPergunta");
		
		query.setParameter("idPergunta",idPergunta);
		
		query.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AlternativaPerguntaAcaoEntity> buscarAlternativasPorIdPergunta(long id) {
		Query query = em.createQuery("select a from AlternativaPerguntaAcaoEntity a where a.perguntaAcaoEntity.id = :id");
		query.setParameter("id", id);
		return query.getResultList();
	}

}
