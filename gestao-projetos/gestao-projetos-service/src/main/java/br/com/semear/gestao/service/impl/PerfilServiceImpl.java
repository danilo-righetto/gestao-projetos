package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.PerfilDAO;
import br.com.semear.gestao.dao.entity.PerfilEntity;
import br.com.semear.gestao.model.Perfil;
import br.com.semear.gestao.service.PerfilService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PerfilServiceImpl implements PerfilService {

	@Inject
	private PerfilDAO perfilDAO;

	@Override
	public void cadastrarPerfil(Perfil perfil) {
		PerfilEntity perfilEn = new PerfilEntity();
		perfilEn.setId("ROLE_" + perfil.getDescricao().toUpperCase());
		perfilEn.setDescricao(perfil.getDescricao());
		perfilDAO.cadastrarPerfil(perfilEn);
	}

	@Override
	public List<Perfil> listarPerfil() {
		List<Perfil> perfis = new ArrayList<Perfil>();
		for (PerfilEntity p : perfilDAO.listarPerfis()) {
			Perfil perfil = new Perfil();
			perfil.setId(p.getId());
			perfil.setDescricao(p.getDescricao());
			perfis.add(perfil);
		}
		return perfis;
	}

}
