package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.Usuario;

public interface UsuarioService {
	public void cadastrarUsuario(Usuario usuario);

	Usuario buscarUsuarioPorLogin(String login);

	public List<Usuario> listarUsuarios();

	public Usuario buscarUsuarioPorId(long idUsuario);
	
	public List<Usuario> buscarUsuarioPorParceiro(long idParceiro, String idPerfil);

	public void editarUsuario(Usuario usuario);

	public String enviarEmailNovaSenha(String email);

	public Usuario buscarUsuarioRedefinirSenha(String hash);

	public String redefinirSenha(String novaSenha, String confirmaNovaSenha,String email, String hash);

	Usuario buscarDadosDoUsuarioAtivo(String email);

	String geraHash(String valor);

	public List<Usuario> buscarUsuarioPorParceiro(long idParceiro);

	public List<Usuario> listarColaboradoresDasParceiros(List<Long> idParceiros, String idPerfil);
}