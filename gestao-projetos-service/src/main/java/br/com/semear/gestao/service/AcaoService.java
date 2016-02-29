package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.dao.entity.AcaoEntity;
import br.com.semear.gestao.model.Acao;

public interface AcaoService {
	public void cadastrar(Acao acao);

	public List<AcaoEntity> listarAcoes();
}