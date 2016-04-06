package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.Colaborador;

public interface ColaboradorService {
	public void cadastrar(Colaborador colaborador);

	public void editar(Colaborador colaborador);

	public List<Colaborador> listarColaboradores(long idParceiro);

	public Colaborador buscarColaboradorPorId(long idColaborador);

//	public List<Colaborador> listarCoordenadoresDoParceiro(long idParceiro, String idPerfil);

	public List<Colaborador> listarColaboradoresDosParceiros(List<Long> idParceiros, String idPerfil);
}