package br.com.semear.gestao.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.PerfilDAO;
import br.com.semear.gestao.dao.entity.PerfilEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class PerfilDaoImpl implements PerfilDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void cadastrarPerfil(PerfilEntity perfil) {
		em.persist(perfil);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PerfilEntity> listarPerfis() {
		Query query = em.createQuery("select pe from PerfilEntity pe");
		
		List<PerfilEntity> perfis = null;
		
		if(!query.getResultList().isEmpty()){
			perfis = query.getResultList();
		}else{
			System.out.println("Lista Vazia");
			perfis = new ArrayList<PerfilEntity>();
		}
		return perfis;
	}
}