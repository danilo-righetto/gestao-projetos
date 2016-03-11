package br.com.semear.gestao.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.RecuperaSenhaDAO;
import br.com.semear.gestao.dao.UsuarioDAO;
import br.com.semear.gestao.dao.entity.InstituicaoEntity;
import br.com.semear.gestao.dao.entity.PerfilEntity;
import br.com.semear.gestao.dao.entity.RequisicaoSenhaEntity;
import br.com.semear.gestao.dao.entity.UsuarioEntity;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.MailService;
import br.com.semear.gestao.service.ParseService;
import br.com.semear.gestao.service.UsuarioService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UsuarioServiceImpl implements UsuarioService {

	@Inject
	private ParseService parseService;
	
	@Inject
	private MailService mailService;
	
	@Inject
	private RecuperaSenhaDAO recuperaSenhaDAO;
	
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
		user.setInstituicao(new InstituicaoEntity(usuario.getInstituicao().getId()));
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
			if(usuario.getInstituicao() == null){
				entity.setInstituicao(null);
			}else{
				entity.setInstituicao(new InstituicaoEntity(usuario.getInstituicao().getId()));
			}
			entity.setRealizaLogin(usuario.getRealizaLogin());
			usuarioDAO.editarUsuario(entity);
		}		
	}

	@Override
	public String enviarEmailNovaSenha(String email) {
		String mensagem = "ERRO";
		try {
			boolean existe = usuarioDAO.verificaExistenciaUsuario(email);
			if (existe) {
				boolean jaEnviado = recuperaSenhaDAO
						.possuiRequisicaoNovaSenha(email);
				if (!jaEnviado) {
					String hash = inserirRequisicaoDeSenha(email);
					mailService.enviarEmailNovaSenha(email, hash);

					mensagem = "OK";
				} else {
					mensagem = "NOK";
				}
			} else {
				mensagem = "NE";
			}
		} catch (Exception e) {
			mensagem = "ERRO";
		}

		return mensagem;
	}

	@Override
	public Usuario buscarUsuarioRedefinirSenha(String hash) {
		RequisicaoSenhaEntity requisicao = recuperaSenhaDAO
				.buscarUsuarioRedefinirSenha(hash);
		Usuario usuario = null;
		if (requisicao != null) {
			usuario = buscarDadosDoUsuarioAtivo(requisicao.getEmail());
		}
		return usuario;
	}

	@Override
	public String redefinirSenha(String novaSenha, String confirmaNovaSenha,String email, String hash) {
		String mensagem = "ERRO";
		Usuario usuario = buscarDadosDoUsuarioAtivo(email);
		if (usuario != null) {
			if (novaSenha.equals(confirmaNovaSenha)) {
				usuarioDAO.alterarSenha(parseService.parseToEntity(usuario),
						passwordEncoder.encode(novaSenha));
				RequisicaoSenhaEntity requisicao = recuperaSenhaDAO
						.buscarUsuarioRedefinirSenha(hash);
				recuperaSenhaDAO.removerSolicitacao(requisicao);
				mensagem = "OK";
			} else {
				mensagem = "ERRO_NOVA_SENHA";
			}
		}
		return mensagem;
	}
	
	private String inserirRequisicaoDeSenha(String email) {
		RequisicaoSenhaEntity nova = new RequisicaoSenhaEntity();
		nova.setDataCadastro(Calendar.getInstance());
		nova.setEmail(email);
		nova.setHashUrl(geraHash(email));
		recuperaSenhaDAO.inserirRequisicao(nova);
		return nova.getHashUrl();
	}
	
	@Override
	public Usuario buscarDadosDoUsuarioAtivo(String email) {
		
		Usuario usuario = parseService.parseToModel(usuarioDAO.buscarDadosDoUsuarioAtivo(email));

		return usuario;
	}
	
	@Override
	public String geraHash(String valor) {
		String result = valor + Calendar.getInstance().getTimeInMillis();
		MessageDigest md;
		StringBuilder s = new StringBuilder();
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(result.getBytes());
			byte[] hashMd5 = md.digest();

			for (int i = 0; i < hashMd5.length; i++) {
				int parteAlta = ((hashMd5[i] >> 4) & 0xf) << 4;
				int parteBaixa = hashMd5[i] & 0xf;
				if (parteAlta == 0)
					s.append('0');
				s.append(Integer.toHexString(parteAlta | parteBaixa));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return s.toString();
	}

	@Override
	public List<Usuario> buscarUsuarioPorInstituicao(long idInstituicao, String idPerfil) {
		List<UsuarioEntity> entity = usuarioDAO.buscarUsuarioPorInstituicao(idInstituicao, idPerfil);
		List<Usuario> usuarios = new ArrayList<Usuario>();
		for(UsuarioEntity i : entity){
			usuarios.add(parseService.parseToModel(i));
		}
		return usuarios;
	}
}
