package br.com.semear.gestao.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.InstituicaoDAO;
import br.com.semear.gestao.dao.entity.InstituicaoEntity;
import br.com.semear.gestao.model.Instituicao;
import br.com.semear.gestao.service.InstituicaoService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class InstituicaoServiceImpl implements InstituicaoService{
	
	@Inject
	private InstituicaoDAO instituicaoDAO;

	@Override
	public void cadastrarInstituicao(Instituicao instituicao) {
		InstituicaoEntity inst = new InstituicaoEntity();
		inst.setNomefantasia(instituicao.getNomefantasia());
		inst.setRazaosocial(instituicao.getRazaosocial());
		inst.setDocumento(instituicao.getDocumento());
		inst.setTipoDocumento(instituicao.getTipoDocumento());
		inst.setLogradouro(instituicao.getLogradouro());
		inst.setNumero(instituicao.getNumero());
		inst.setComplemento(instituicao.getComplemento());
		inst.setBairro(instituicao.getBairro());
		inst.setCep(instituicao.getCep());
		inst.setUf(instituicao.getUf());
		inst.setCidade(instituicao.getCidade());
		inst.setTelefone(instituicao.getTelefone());
		inst.setEmail(instituicao.getEmail());
		inst.setResponsavel(instituicao.getResponsavel());
		
		instituicaoDAO.cadastrarInstituicao(inst);
	}

}
