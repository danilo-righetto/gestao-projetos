package br.com.semear.gestao.service;

import br.com.semear.gestao.model.Reeducando;

public interface ReeducandoService {
	public void cadastrarReeducando(Reeducando reeducando);

	public Reeducando buscarReeducandoPorId(long idReeducando);
}