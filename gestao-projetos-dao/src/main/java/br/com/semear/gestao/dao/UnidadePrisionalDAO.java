package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.UnidadePrisionalEntity;
import br.com.semear.gestao.dao.entity.UnidadeRelInstituicaoEntity;

public interface UnidadePrisionalDAO {
	public void cadastrar(UnidadePrisionalEntity unidadePrisional);

	public void editar(UnidadePrisionalEntity unidadePrisional);

	public void excluir(UnidadePrisionalEntity unidadePrisional);

	public List<UnidadePrisionalEntity> listarUnidades();

	public UnidadePrisionalEntity buscarUnidadePrisionalPorId(long idUnidadePrisional);

	public List<UnidadePrisionalEntity> buscarUnidadePrisionalPorInstituicao(long idInstituicao);

	public List<UnidadePrisionalEntity> listarUnidadesPorStatus(boolean status);

	public void adicionarVinculoInstituicaoComUnidadePrisional(UnidadeRelInstituicaoEntity rel);
}