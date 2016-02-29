package br.com.semear.gestao.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.semear.gestao.model.Acao;
import br.com.semear.gestao.service.AcaoService;

@Controller
@RequestMapping("painel/acoes")
public class AcaoController {
	ModelAndView mav = new ModelAndView();
	
	@Inject
	private AcaoService acaoService;
	
	@RequestMapping("cadastro")
	public ModelAndView cadastrarAcao() {
		mav = new ModelAndView("cadastroAcao");
		return mav;
	}
	
	public String salvarAcao(Acao acao){
		acaoService.cadastrar(acao);
		return"redirect:/cadastroAcao";
	}
}