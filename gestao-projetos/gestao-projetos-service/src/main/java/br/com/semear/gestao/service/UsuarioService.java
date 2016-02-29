package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.Usuario;

public interface UsuarioService {
	public void cadastrarUsuario(Usuario usuario);

	Usuario buscarUsuarioPorLogin(String login);

	public List<Usuario> listarUsuarios();

	public Usuario buscarUsuarioPorId(long idUsuario);

	public void editarUsuario(Usuario usuario);
}