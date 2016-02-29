package br.com.semear.gestao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.UsuarioDAO;
import br.com.semear.gestao.dao.entity.UsuarioEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class UsuarioDaoImpl implements UsuarioDAO{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void cadastrarUsuario(UsuarioEntity usuario) {
		em.persist(usuario);
	}
	
	@Override
	public UsuarioEntity buscarUsuarioPorLogin(String login){
		Query query = em.createQuery("select u from UsuarioEntity u where u.usuario = :login");
		query.setParameter("login", login);
		if(!query.getResultList().isEmpty()){
			return (UsuarioEntity) query.getSingleResult();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioEntity> listarUsuarios() {
		Query query = em.createQuery("select u from UsuarioEntity u");
		return query.getResultList();
	}

	@Override
	public UsuarioEntity buscarUsuarioPorId(long idUsuario) {
		Query query = em.createQuery("select u from UsuarioEntity u where u.id = :idUsuario");
		query.setParameter("idUsuario", idUsuario);
		if(!query.getResultList().isEmpty()){
			return (UsuarioEntity) query.getSingleResult();
		}
		return null;
	}

	@Override
	public void editarUsuario(UsuarioEntity entity) {
		UsuarioEntity usuario = entity;
		em.merge(usuario);		
	}
}
