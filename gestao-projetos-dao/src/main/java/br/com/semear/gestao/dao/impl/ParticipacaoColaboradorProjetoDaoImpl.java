package br.com.semear.gestao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ParticipacaoColaboradorProjetoDAO;
import br.com.semear.gestao.dao.entity.ParticipacaoColaboradorProjetoEntity;
import br.com.semear.gestao.dao.entity.UsuarioEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ParticipacaoColaboradorProjetoDaoImpl implements ParticipacaoColaboradorProjetoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void cadastrar(ParticipacaoColaboradorProjetoEntity entity) {
		em.persist(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UsuarioEntity> listarColaboradoresDoProjeto(long idProjeto, String idPerfil) {
		Query query = em.createQuery("select p.colaborador from ParticipacaoColaboradorProjetoEntity p "
				+ "where p.projeto.id = :idProjeto and p.colaborador.perfil.id = :idPerfil");
		query.setParameter("idProjeto", idProjeto);
		query.setParameter("idPerfil", idPerfil);
		return query.getResultList();
	}

//	@Override
//	@SuppressWarnings("unchecked")
//	public List<UsuarioEntity> listarAssociadosDoProjeto(Long idProjeto, String idPerfil) {
//		Query query = em.createQuery("select p.colaborador from ParticipacaoColaboradorProjetoEntity p "
//				+ "where p.projeto.id = :idProjeto and p.colaborador.perfil.id = :idPerfil");
//		query.setParameter("idProjeto", idProjeto);
//		query.setParameter("idPerfil", idPerfil);
//		return query.getResultList();
//	}
}