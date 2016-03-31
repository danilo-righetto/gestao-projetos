package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ColaboradorDAO;
import br.com.semear.gestao.dao.entity.ColaboradorEntity;
import br.com.semear.gestao.model.Colaborador;
import br.com.semear.gestao.model.Instituicao;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.ColaboradorService;
import br.com.semear.gestao.service.InstituicaoService;
import br.com.semear.gestao.service.MailService;
import br.com.semear.gestao.service.ParseService;
import br.com.semear.gestao.service.UsuarioService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ColaboradorServiceImpl implements ColaboradorService {

	@Inject
	private PasswordEncoder passwordEncoder;

	@Inject
	private ParseService parse;

	@Inject
	private MailService mailService;

	@Inject
	private ColaboradorDAO colaboradorDAO;

	@Inject
	private InstituicaoService instituicaoService;

	@Inject
	private UsuarioService usuarioService;

	@Override
	public void cadastrar(Colaborador colaborador) {
		String senha = geradorSenha(8);
		Instituicao parceiro = instituicaoService.buscarInstituicaoPorId(colaborador.getParceiro().getId());
		Usuario usuario = new Usuario();
		usuario.setNome(colaborador.getNome());
		usuario.setUsuario(colaborador.getEmail());
		usuario.setPerfil(colaborador.getUsuario().getPerfil());
		usuario.setInstituicao(parceiro);
		usuario.setRealizaLogin(true);
		usuario.setDataCadastro(Calendar.getInstance());

		usuario.setSenha(passwordEncoder.encode(senha));
		colaborador.setUsuario(usuario);
		colaborador.setParceiro(parceiro);
		colaboradorDAO.cadastrar(parse.parseToEntity(colaborador));
		mailService.enviarEmailSenhaCriada(colaborador.getEmail(), senha);
	}

	@Override
	public void editar(Colaborador colaborador) {
		Usuario usuario = usuarioService.buscarUsuarioPorId(colaborador.getUsuario().getId());
		Instituicao parceiro = instituicaoService.buscarInstituicaoPorId(colaborador.getParceiro().getId());
		
		usuario.setNome(colaborador.getNome());
		usuario.setUsuario(colaborador.getEmail());
		usuario.setPerfil(colaborador.getUsuario().getPerfil());
		colaborador.setUsuario(usuario);
		colaborador.setParceiro(parceiro);
		colaboradorDAO.editar(parse.parseToEntity(colaborador));
	}

	@Override
	public List<Colaborador> listarColaboradores(long idInstituicao) {
		List<ColaboradorEntity> lista = colaboradorDAO.listarColaboradores(idInstituicao);
		List<Colaborador> colaboradores = new ArrayList<Colaborador>();
		for (ColaboradorEntity colaborador : lista) {
			colaboradores.add(parse.parseToModel(colaborador));
		}
		return colaboradores;
	}

	public String geradorSenha(int qtd) {
		char[] rnd = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
				'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
				'Z' };
		String senha = new String();
		for (int i = 0; i < 8; i++) {
			Integer pchar = (int) (Math.random() * rnd.length);
			senha += (rnd[pchar]);
		}
		return senha;
	}

	@Override
	public Colaborador buscarColaboradorPorId(long idColaborador) {
		return parse.parseToModel(colaboradorDAO.buscarColaboradorPorId(idColaborador));
	}
}