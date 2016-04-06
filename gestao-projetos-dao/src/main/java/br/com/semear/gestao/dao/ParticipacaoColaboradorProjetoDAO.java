package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.ParticipacaoColaboradorProjetoEntity;
import br.com.semear.gestao.dao.entity.UsuarioEntity;

public interface ParticipacaoColaboradorProjetoDAO {
	public void cadastrar(ParticipacaoColaboradorProjetoEntity entity);

	public List<UsuarioEntity> listarColaboradoresDoProjeto(long idProjeto, String idPerfil);

//	public List<UsuarioEntity> listarAssociadosDoProjeto(Long idProjeto, String idPerfil);
}