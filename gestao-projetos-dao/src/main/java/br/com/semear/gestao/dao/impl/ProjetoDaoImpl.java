package br.com.semear.gestao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ProjetoDAO;
import br.com.semear.gestao.dao.entity.AcaoRelProjetoEntity;
import br.com.semear.gestao.dao.entity.ParceiroEntity;
import br.com.semear.gestao.dao.entity.ProjetoEntity;
import br.com.semear.gestao.dao.entity.UnidadePrisionalEntity;
import br.com.semear.gestao.dao.entity.UsuarioEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ProjetoDaoImpl implements ProjetoDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public long cadastrarProjeto(ProjetoEntity projeto) {
		em.persist(projeto);
		return projeto.getId();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProjetoEntity> listarTodosProjetos() {
		Query query = em.createQuery("select p from ProjetoEntity p");
		return query.getResultList();
	}

	@Override
	public ProjetoEntity buscarProjetoPorNome(String nome){
		Query query = em.createQuery("select p from ProjetoEntity p where p.nome = :nome");
		query.setParameter("nome", nome);
		return (ProjetoEntity) query.getSingleResult();
	}

	@Override
	public ProjetoEntity buscarProjetoPorId(long idProjeto) {
		Query query = em.createQuery("select p from ProjetoEntity p where p.id = :idProjeto");
		query.setParameter("idProjeto", idProjeto);
		return (ProjetoEntity) query.getSingleResult();
	}

	@Override
	public void editarProjeto(ProjetoEntity entity) {
		ProjetoEntity projeto = entity;
		em.merge(projeto);
	}

	@Override
	public long buscarUnidadePrisionalDoProjeto(long idProjeto) {
		Query query = em.createQuery("select p.unidadePrisional from ProjetoEntity p where p.id = :idProjeto");
		query.setParameter("idProjeto", idProjeto);
		UnidadePrisionalEntity entity = (UnidadePrisionalEntity) query.getSingleResult();
		return entity.getId();
	}

	@Override
	public UsuarioEntity buscarCoordenadorPorIdProjeto(long idProjeto) {
		Query query = em.createQuery("select p.coordenador from ProjetoEntity p where p.id = :idProjeto");
		query.setParameter("idProjeto", idProjeto);
		if(!query.getResultList().isEmpty()){
			return (UsuarioEntity) query.getResultList().get(0);
		}else{
			return null;
		}
	}
	
	@Override
	public ParceiroEntity buscarParceiroDoCoodernadorPorIdProjeto(long idProjeto) {
		Query query = em.createQuery("select p.coordenador.parceiro from ProjetoEntity p where p.id = :idProjeto");
		query.setParameter("idProjeto", idProjeto);
		if(!query.getResultList().isEmpty()){
			return (ParceiroEntity) query.getResultList().get(0);
		}else{
			return null;
		}
	}

	@Override
	public void adicionarVinculoAcaoComProjeto(AcaoRelProjetoEntity rel) {
		em.persist(rel);
	}
}
