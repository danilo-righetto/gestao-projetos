package br.com.semear.gestao.service.impl;

import org.springframework.stereotype.Service;

import br.com.semear.gestao.service.UtilService;

@Service
public class UtilServiceImpl implements UtilService {

	private static final int TAMANHO_SENHA = 8;
	
	@Override
	public String gerarSenha() {
		String senha = "";
		char[] rand = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
				'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
				'Z' };
		for (int i = 0; i < TAMANHO_SENHA; i++) {
			Integer pchar = (int) (Math.random() * rand.length);
			senha += (rand[pchar]);
		}
		return senha;
	}
}