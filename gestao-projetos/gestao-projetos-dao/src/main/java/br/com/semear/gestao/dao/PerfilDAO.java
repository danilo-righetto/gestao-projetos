package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.PerfilEntity;

public interface PerfilDAO {
	public void cadastrarPerfil(PerfilEntity perfil);

	public List<PerfilEntity> listarPerfis();
}
