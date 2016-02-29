package br.com.semear.gestao.dao;

import br.com.semear.gestao.dao.entity.ReeducandoEntity;

public interface ReeducandoDAO {
	public void cadastrarReeducando(ReeducandoEntity reeducando);

	ReeducandoEntity buscarReeducandoPorId(long idReeducando);
}