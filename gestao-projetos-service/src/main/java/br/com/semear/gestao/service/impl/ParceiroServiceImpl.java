package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ParceiroDAO;
import br.com.semear.gestao.dao.entity.ParceiroEntity;
import br.com.semear.gestao.model.Parceiro;
import br.com.semear.gestao.service.ParceiroService;
import br.com.semear.gestao.service.ParseService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ParceiroServiceImpl implements ParceiroService {

	@Inject
	private ParceiroDAO parceiroDAO;

	@Inject
	private ParseService parse;

	@Override
	public String cadastrarParceiro(Parceiro parceiro) {
		parceiro.setDataCadastro(Calendar.getInstance());
		parceiro.setStatus("ATIVO");
		parceiro.setId(parceiroDAO.cadastrarParceiro(parse.parseToEntity(parceiro)));
		if(parceiro.getId() > 0){
			return "OK";
		}
		return "NOK";
	}

	@Override
	public List<Parceiro> listarParceiros() {
		List<ParceiroEntity> lista = parceiroDAO.listarParceiros();
		List<Parceiro> parceiros = new ArrayList<Parceiro>();
		if (lista != null) {
			for (ParceiroEntity p : lista) {
				parceiros.add(parse.parseToModel(p));
			}
		}
		return parceiros;
	}

	@Override
	public void editarParceiro(Parceiro parceiro) {
		//for?
		ParceiroEntity entity = parceiroDAO.buscarParceiroPorId(parceiro.getId());
		if (entity != null) {
			entity.setRazaosocial(parceiro.getRazaosocial().toUpperCase());
			entity.setNomefantasia(parceiro.getNomefantasia() != null ? parceiro.getNomefantasia().toUpperCase() :
				parceiro.getRazaosocial().toUpperCase());
			entity.setLogradouro(parceiro.getLogradouro().toUpperCase());
			entity.setNumero(parceiro.getNumero().toUpperCase());
			entity.setComplemento(parceiro.getComplemento().toUpperCase());
			entity.setBairro(parceiro.getBairro().toUpperCase());
			entity.setCep(parceiro.getCep().toUpperCase());
			entity.setUf(parceiro.getUf().toUpperCase());
			entity.setCidade(parceiro.getCidade().toUpperCase());
			entity.setTelefone(parceiro.getTelefone().toUpperCase());
			entity.setEmail(parceiro.getEmail().toLowerCase());
			entity.setResponsavel(parceiro.getResponsavel().toUpperCase());
			entity.setStatus(parceiro.getStatus());
			parceiroDAO.editarParceiro(entity);
		}
	}

	@Override
	public Parceiro buscarParceiroPorId(Long idParceiro) {
		ParceiroEntity entity = parceiroDAO.buscarParceiroPorId(idParceiro);
		Parceiro parceiro = parse.parseToModel(entity);
		return parceiro;
	}

	@Override
	public Parceiro buscarParceiroPorDocumento(String documento) {
		ParceiroEntity entity = parceiroDAO.buscarParceiroPorDocumento(documento);
		Parceiro parceiro = parse.parseToModel(entity);
		return parceiro;
	}

	@Override
	public long buscarUnidadePrisionalPorParceiro(long idParceiro) {
		return parceiroDAO.buscarUnidadePrisionalPorParceiro(idParceiro);
	}

	@Override
	public List<Parceiro> buscarParceiroPorUnidade(long idUnidadePrisional) {
		List<ParceiroEntity> lista = parceiroDAO.buscarParceiroPorUnidade(idUnidadePrisional);
		List<Parceiro> parceiro = new ArrayList<Parceiro>();
		for (ParceiroEntity entity : lista) {
			parceiro.add(parse.parseToModel(entity));
		}
		return parceiro;
	}

	@Override
	public List<Parceiro> buscarParceirosPorId(Long[] idParceiros) {
		if (idParceiros != null) {
			List<ParceiroEntity> lista = parceiroDAO.buscarParceiroPorId(idParceiros);
			List<Parceiro> parceiro = new ArrayList<Parceiro>();
			for (ParceiroEntity entity : lista) {
				parceiro.add(parse.parseToModel(entity));
			}
			return parceiro;
		}
		return null;
	}

	@Override
	public long buscarUnidadePrisionalPorProjeto(long idProjeto) {
		// TODO Auto-generated method stub
		return 0;
	}
}