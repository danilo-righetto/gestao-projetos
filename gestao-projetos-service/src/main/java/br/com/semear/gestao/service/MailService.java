package br.com.semear.gestao.service;

public interface MailService {

	void enviarEmailNovaSenha(String email, String hash);

}
