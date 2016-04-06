package br.com.semear.gestao.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ColaboradorDAO;
import br.com.semear.gestao.dao.entity.ColaboradorEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ColaboradorDaoImpl implements ColaboradorDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void cadastrar(ColaboradorEntity entity) {
		em.persist(entity);
	}

	@Override
	public void editar(ColaboradorEntity entity) {
		em.merge(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ColaboradorEntity> listarColaboradores(long idParceiro) {
		Query query = em.createQuery("select c from ColaboradorEntity c where c.usuario.parceiro.id = :idParceiro");
		query.setParameter("idParceiro", idParceiro);
		if (!query.getResultList().isEmpty()) {
			return query.getResultList();
		}
		return new ArrayList<ColaboradorEntity>();
	}

	@Override
	public ColaboradorEntity buscarColaboradorPorId(long idColaborador) {
		Query query = em.createQuery("select c from ColaboradorEntity c where c.id = :idColaborador");
		query.setParameter("idColaborador", idColaborador);
		return (ColaboradorEntity) query.getSingleResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ColaboradorEntity> listarColaboradoresDosParceiros(List<Long> idParceiros, String idPerfil) {
		Query query = em.createQuery(
				"select c from ColaboradorEntity c where c.usuario.parceiro.id in(:idParceiros) and c.usuario.perfil.id = :idPerfil order by c.nome");
		query.setParameter("idParceiros", idParceiros);
		query.setParameter("idPerfil", idPerfil);
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ColaboradorEntity> listarCoordenadoresDoParceiro(long idParceiro, String idPerfil) {
		Query query = em.createQuery(
				"select c from ColaboradorEntity c where c.usuario.parceiro.id = :idParceiro and c.usuario.perfil.id = :idPerfil");
		query.setParameter("idParceiro", idParceiro);
		query.setParameter("idPerfil", idPerfil);
		if (!query.getResultList().isEmpty()) {
			return query.getResultList();
		}
		return new ArrayList<ColaboradorEntity>();
	}
}