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
import br.com.semear.gestao.dao.entity.ProjetoEntity;
import br.com.semear.gestao.dao.entity.UnidadePrisionalEntity;
import br.com.semear.gestao.model.Instituicao;
import br.com.semear.gestao.service.InstituicaoService;
import br.com.semear.gestao.service.ParseService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class InstituicaoServiceImpl implements InstituicaoService{
	
	@Inject
	private InstituicaoDAO instituicaoDAO;
	
	@Inject
	private ParseService parse;

	@Override
	public void cadastrarInstituicao(Instituicao instituicao) {
		instituicao.setDataCadastro(Calendar.getInstance());
		instituicao.setStatus("ATIVO");
		instituicaoDAO.cadastrarInstituicao(parse.parseToEntity(instituicao));
	}

	@Override
	public List<Instituicao> listarInstituicoes() {
		List<InstituicaoEntity> instituicoesEntity = instituicaoDAO.listarInstituicoes();
		List<Instituicao> instituicoes = new ArrayList<Instituicao>();
		if(instituicoesEntity != null){
			for(InstituicaoEntity u : instituicoesEntity){
				instituicoes.add(parse.parseToModel(u));
			}
		}
		return instituicoes;
	}

	@Override
	public void editarInstituicao(Instituicao instituicao) {
		InstituicaoEntity entity = instituicaoDAO.buscarInstituicaoPorId(instituicao.getId());
		if(entity != null){
			entity.setId(instituicao.getId());
			entity.setNomefantasia(instituicao.getNomefantasia());
			entity.setRazaosocial(instituicao.getRazaosocial());
			entity.setDocumento(instituicao.getDocumento());
			entity.setTipoDocumento(instituicao.getTipoDocumento());
			entity.setLogradouro(instituicao.getLogradouro());
			entity.setNumero(instituicao.getNumero());
			entity.setComplemento(instituicao.getComplemento());
			entity.setBairro(instituicao.getBairro());
			entity.setCep(instituicao.getCep());
			entity.setUf(instituicao.getUf());
			entity.setCidade(instituicao.getCidade());
			entity.setTelefone(instituicao.getTelefone());
			entity.setEmail(instituicao.getEmail());
			entity.setResponsavel(instituicao.getResponsavel());
			entity.setProjetoInstituicao(new ProjetoEntity(instituicao.getProjetoInstituicao().getId()));
			entity.setDataCadastro(instituicao.getDataCadastro());
			entity.setStatus(instituicao.getStatus());
			entity.setUnidadePrisional(new UnidadePrisionalEntity(instituicao.getUnidadePrisional().getId()));
			
			instituicaoDAO.editarInstituicao(entity);
		}
		
	}


	@Override
	public Instituicao buscarInstituicaoPorId(long idInstituicao) {
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

}
