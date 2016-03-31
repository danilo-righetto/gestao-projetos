package br.com.semear.gestao.dao.impl;

import java.util.ArrayList;
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
public class UsuarioDaoImpl implements UsuarioDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void cadastrarUsuario(UsuarioEntity usuario) {
		em.persist(usuario);
	}

	@Override
	public UsuarioEntity buscarUsuarioPorLogin(String login) {
		Query query = em.createQuery("select u from UsuarioEntity u where u.usuario = :login");
		query.setParameter("login", login);
		if (!query.getResultList().isEmpty()) {
			return (UsuarioEntity) query.getSingleResult();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioEntity> listarUsuarios() {
		Query query = em.createQuery("select u from UsuarioEntity u where u.perfil.id != 'ROLE_REEDUCANDO'");
		return query.getResultList();
	}

	@Override
	public UsuarioEntity buscarUsuarioPorId(long idUsuario) {
		Query query = em.createQuery("select u from UsuarioEntity u where u.id = :idUsuario");
		query.setParameter("idUsuario", idUsuario);
		if (!query.getResultList().isEmpty()) {
			return (UsuarioEntity) query.getSingleResult();
		}
		return null;
	}

	@Override
	public void editarUsuario(UsuarioEntity entity) {
		UsuarioEntity usuario = entity;
		em.merge(usuario);
	}

	@Override
	public boolean verificaExistenciaUsuario(String email) {
		Query query = em
				.createQuery("select u from UsuarioEntity as u where u.realizaLogin = 1 and u.usuario = :paramEmail");
		query.setParameter("paramEmail", email);
		if (!query.getResultList().isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public void alterarSenha(UsuarioEntity usuario, String novaSenha) {
		usuario.setSenha(novaSenha);
		em.merge(usuario);
	}

	@Override
	public UsuarioEntity buscarDadosDoUsuarioAtivo(String email) {
		UsuarioEntity usuario = null;
		Query query = em
				.createQuery("select u from UsuarioEntity as u where u.realizaLogin = 1 and u.usuario = :paramLogin");
		query.setParameter("paramLogin", email);
		if (!query.getResultList().isEmpty()) {
			usuario = (UsuarioEntity) query.getResultList().get(0);
		}
		return usuario;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UsuarioEntity> buscarUsuarioPorParceiro(long idParceiro, String idPerfil) {
		Query query = em.createQuery(
				"select u from UsuarioEntity u where u.parceiro.id = :idParceiro and u.perfil.id = :idPerfil");
		query.setParameter("idParceiro", idParceiro);
		query.setParameter("idPerfil", idPerfil);
		if (!query.getResultList().isEmpty()) {
			return query.getResultList();
		}
		return new ArrayList<UsuarioEntity>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioEntity> buscarUsuarioPorParceiro(long idParceiro) {
		Query query = em.createQuery("select u from UsuarioEntity u where u.parceiro.id = :idParceiro");
		query.setParameter("idParceiro", idParceiro);
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UsuarioEntity> listarColaboradoresDasParceiros(List<Long> idParceiros, String idPerfil) {
		Query query = em.createQuery(
				"select u from UsuarioEntity u where u.parceiro.id in(:idParceiros) and u.perfil.id = :idPerfil order by u.nome");
		query.setParameter("idParceiros", idParceiros);
		query.setParameter("idPerfil", idPerfil);
		return query.getResultList();
	}
}
