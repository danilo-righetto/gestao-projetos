package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.UsuarioDAO;
import br.com.semear.gestao.dao.entity.PerfilEntity;
import br.com.semear.gestao.dao.entity.UsuarioEntity;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.ParseService;
import br.com.semear.gestao.service.UsuarioService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UsuarioServiceImpl implements UsuarioService {

	@Inject
	private ParseService parseService;
	
	@Inject
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Usuario buscarUsuarioPorLogin(String login){
		UsuarioEntity entity = usuarioDAO.buscarUsuarioPorLogin(login);
		Usuario usuario = parseService.parseToModel(entity);
		return usuario;
		
	}
	
	@Override
	public void cadastrarUsuario(Usuario usuario) {
		UsuarioEntity user = new UsuarioEntity();
		user.setNome(usuario.getNome());
		user.setUsuario(usuario.getUsuario());
		user.setSenha(passwordEncoder.encode(usuario.getSenha()));
		user.setPerfil(new PerfilEntity(usuario.getPerfil().getId()));
		user.setDataCadastro(Calendar.getInstance());
		user.setRealizaLogin(usuario.getRealizaLogin());
		
		usuarioDAO.cadastrarUsuario(user);
	}
	
	@Inject
	private UsuarioDAO usuarioDAO;

	@Override
	public List<Usuario> listarUsuarios() {
		List<UsuarioEntity> usuariosEntity = usuarioDAO.listarUsuarios();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		if(usuariosEntity != null){
			for(UsuarioEntity u : usuariosEntity){
				usuarios.add(parseService.parseToModel(u));
			}
		}
		return usuarios;
	}

	@Override
	public Usuario buscarUsuarioPorId(long idUsuario) {
		UsuarioEntity entity = usuarioDAO.buscarUsuarioPorId(idUsuario);
		Usuario usuario = parseService.parseToModel(entity);
		return usuario;
	}

	@Override
	public void editarUsuario(Usuario usuario) {
		UsuarioEntity entity = usuarioDAO.buscarUsuarioPorId(usuario.getId());
		if(entity != null){
			entity.setNome(usuario.getNome());
			entity.setPerfil(new PerfilEntity(usuario.getPerfil().getId()));
			entity.setRealizaLogin(usuario.getRealizaLogin());
			usuarioDAO.editarUsuario(entity);
		}		
	}
}
