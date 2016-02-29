package br.com.semear.gestao.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.semear.gestao.model.Perfil;
import br.com.semear.gestao.service.PerfilService;

@Controller
public class PerfilController {
	
	@Inject
	private PerfilService perfilService;
	
	@RequestMapping("/cadastroPerfil")
	public String index(){
		return "cadastroPerfil";
	}
	
	@RequestMapping(value="salvarPerfil", method=RequestMethod.POST)
	public String salvarPerfil(Perfil perfil){
		perfilService.cadastrarPerfil(perfil);
		return "redirect:/cadastroPerfil";
	}
}
