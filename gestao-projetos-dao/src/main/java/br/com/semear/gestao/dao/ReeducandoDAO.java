package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.ReeducandoEntity;

public interface ReeducandoDAO {
	public void cadastrarReeducando(ReeducandoEntity reeducando);
	
	public void editarReeducando(ReeducandoEntity reeducando);
	
	public List<ReeducandoEntity> listarReeducandos();

	public ReeducandoEntity buscarReeducandoPorId(long idReeducando);

	public ReeducandoEntity buscarMatricula(long matricula);

	List<ReeducandoEntity> listarReeducandosPorUnidadePrisional(long idUnidadePrisional);
}