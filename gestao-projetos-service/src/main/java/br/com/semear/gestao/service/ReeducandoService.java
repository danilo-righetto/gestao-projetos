package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.Reeducando;

public interface ReeducandoService {
	public void cadastrarReeducando(Reeducando reeducando);

	public void editarReeducando(Reeducando reeducando);

	public List<Reeducando> listarReeducandos();

	public Reeducando buscarReeducandoPorId(long idReeducando);

	boolean verficarMatricula(long matricula);
}