package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.Perfil;

public interface PerfilService {
	public void cadastrarPerfil(Perfil perfil);

	public List<Perfil> listarPerfil();
}
