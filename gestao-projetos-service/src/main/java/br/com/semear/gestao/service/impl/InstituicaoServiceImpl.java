package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.InstituicaoDAO;
import br.com.semear.gestao.dao.entity.InstituicaoEntity;
import br.com.semear.gestao.model.Instituicao;
import br.com.semear.gestao.service.InstituicaoService;
import br.com.semear.gestao.service.ParseService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class InstituicaoServiceImpl implements InstituicaoService {

	@Inject
	private InstituicaoDAO instituicaoDAO;

	@Inject
	private ParseService parse;

	@Override
	public String cadastrarInstituicao(Instituicao instituicao) {
		instituicao.setDataCadastro(Calendar.getInstance());
		instituicao.setStatus("ATIVO");
		instituicao.setId(instituicaoDAO.cadastrarInstituicao(parse.parseToEntity(instituicao)));
		if(instituicao.getId() > 0){
			return "OK";
		}
		return "NOK";
	}

	@Override
	public List<Instituicao> listarInstituicoes() {
		List<InstituicaoEntity> instituicoesEntity = instituicaoDAO.listarInstituicoes();
		List<Instituicao> instituicoes = new ArrayList<Instituicao>();
		if (instituicoesEntity != null) {
			for (InstituicaoEntity u : instituicoesEntity) {
				instituicoes.add(parse.parseToModel(u));
			}
		}
		return instituicoes;
	}

	@Override
	public void editarInstituicao(Instituicao instituicao) {
		//for?
		InstituicaoEntity entity = instituicaoDAO.buscarInstituicaoPorId(instituicao.getId());
		if (entity != null) {
			entity.setRazaosocial(instituicao.getRazaosocial().toUpperCase());
			entity.setNomefantasia(instituicao.getNomefantasia() != null ? instituicao.getNomefantasia().toUpperCase() :
				instituicao.getRazaosocial().toUpperCase());
			entity.setLogradouro(instituicao.getLogradouro().toUpperCase());
			entity.setNumero(instituicao.getNumero().toUpperCase());
			entity.setComplemento(instituicao.getComplemento().toUpperCase());
			entity.setBairro(instituicao.getBairro().toUpperCase());
			entity.setCep(instituicao.getCep().toUpperCase());
			entity.setUf(instituicao.getUf().toUpperCase());
			entity.setCidade(instituicao.getCidade().toUpperCase());
			entity.setTelefone(instituicao.getTelefone().toUpperCase());
			entity.setEmail(instituicao.getEmail().toLowerCase());
			entity.setResponsavel(instituicao.getResponsavel().toUpperCase());
			entity.setStatus(instituicao.getStatus());
			instituicaoDAO.editarInstituicao(entity);
		}
	}

	@Override
	public Instituicao buscarInstituicaoPorId(Long idInstituicao) {
		InstituicaoEntity entity = instituicaoDAO.buscarInstituicaoPorId(idInstituicao);
		Instituicao instituicao = parse.parseToModel(entity);
		return instituicao;
	}

	@Override
	public Instituicao buscarInstituicaoPorDocumento(String documento) {
		InstituicaoEntity entity = instituicaoDAO.buscarInstituicaoPorDocumento(documento);
		Instituicao instituicao = parse.parseToModel(entity);
		return instituicao;
	}

	@Override
	public long buscarUnidadePrisionalPorInstituicao(long idInstituicao) {
		return instituicaoDAO.buscarUnidadePrisionalPorInstituicao(idInstituicao);
	}

	@Override
	public List<Instituicao> buscarInstituicaoPorUnidade(long idUnidadePrisional) {
		List<InstituicaoEntity> lista = instituicaoDAO.buscarInstituicaoPorUnidade(idUnidadePrisional);
		List<Instituicao> instituicao = new ArrayList<Instituicao>();
		for (InstituicaoEntity entity : lista) {
			instituicao.add(parse.parseToModel(entity));
		}
		return instituicao;
	}

	@Override
	public List<Instituicao> buscarInstituicoesPorId(Long[] idInstituicoes) {
		if (idInstituicoes != null) {
			List<InstituicaoEntity> lista = instituicaoDAO.buscarInstituicaoPorId(idInstituicoes);
			List<Instituicao> instituicao = new ArrayList<Instituicao>();
			for (InstituicaoEntity entity : lista) {
				instituicao.add(parse.parseToModel(entity));
			}
			return instituicao;
		}
		return null;
	}

	@Override
	public long buscarUnidadePrisionalPorProjeto(long idProjeto) {
		// TODO Auto-generated method stub
		return 0;
	}
}