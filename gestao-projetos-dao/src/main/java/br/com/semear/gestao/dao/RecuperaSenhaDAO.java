package br.com.semear.gestao.dao;

import br.com.semear.gestao.dao.entity.RequisicaoSenhaEntity;


public interface RecuperaSenhaDAO {

	boolean possuiRequisicaoNovaSenha(String email);

	RequisicaoSenhaEntity buscarUsuarioRedefinirSenha(String hash);

	void removerSolicitacao(RequisicaoSenhaEntity requisicao);

	void inserirRequisicao(RequisicaoSenhaEntity nova);

}
