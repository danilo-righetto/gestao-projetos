package br.com.semear.gestao.dao;

import java.util.List;
import br.com.semear.gestao.dao.entity.AcaoEntity;

public interface AcaoDAO {
	public void cadastrar(AcaoEntity acao);
	
	public void editar(AcaoEntity acao);
	
	public List<AcaoEntity> listarAcoes();

	public AcaoEntity buscarAcaoPorId(long idAcao);
}