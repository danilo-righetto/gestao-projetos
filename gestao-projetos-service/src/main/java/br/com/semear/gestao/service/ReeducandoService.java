package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.Reeducando;

public interface ReeducandoService {
	public void cadastrarReeducando(Reeducando reeducando);

	public void editarReeducando(Reeducando reeducando);

	public List<Reeducando> listarReeducandos();

	public Reeducando buscarReeducandoPorId(long idReeducando);

	public boolean verficarMatricula(long matricula);
	
	public List<Reeducando> listarReeducandosPorUnidadePrisional(long idUnidadePrisional);
}