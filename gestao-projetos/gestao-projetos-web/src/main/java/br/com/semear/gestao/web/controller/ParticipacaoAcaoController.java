package br.com.semear.gestao.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.semear.gestao.model.ParticipacaoAcao;
import br.com.semear.gestao.service.ParticipacaoAcaoService;

@Controller
public class ParticipacaoAcaoController {
	ModelAndView mav = new ModelAndView();
	
	@Inject
	private ParticipacaoAcaoService participacaoAcaoService;
	
	@RequestMapping("/cadastroParticipacaoAcao")
	public ModelAndView index(){
		mav = new ModelAndView();
		
		return mav;
	}
	
	@RequestMapping("salvarParticipacaoAcao")
	public String salvarParticipacaoAcao(ParticipacaoAcao participacaoAcao){
		participacaoAcaoService.cadastrar(participacaoAcao);
		
		return"redirect:/cadastroParticipacaoAcao";
	}
}
