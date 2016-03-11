package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.UsuarioEntity;

public interface UsuarioDAO {
	public void cadastrarUsuario(UsuarioEntity usuario);

	UsuarioEntity buscarUsuarioPorLogin(String login);

	public List<UsuarioEntity> listarUsuarios();

	public UsuarioEntity buscarUsuarioPorId(long idUsuario);
	
	public List<UsuarioEntity> buscarUsuarioPorInstituicao(long idInstituicao, String idPerfil);

	public void editarUsuario(UsuarioEntity entity);

	public boolean verificaExistenciaUsuario(String email);

	public void alterarSenha(UsuarioEntity usuario, String encode);

	public UsuarioEntity buscarDadosDoUsuarioAtivo(String email);

	public List<UsuarioEntity> buscarUsuarioPorInstituicao(long idInstituicao);
}