package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.ColaboradorEntity;

public interface ColaboradorDAO {

	public void cadastrar(ColaboradorEntity entity);

	public void editar(ColaboradorEntity entity);

	public List<ColaboradorEntity> listarColaboradores(long idParceiro);

	public ColaboradorEntity buscarColaboradorPorId(long idColaborador);
}