package br.com.semear.gestao.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.semear.gestao.model.Instituicao;
import br.com.semear.gestao.service.InstituicaoService;

@Controller
public class InstituicaoController {
	private ModelAndView mav = new ModelAndView();
	
	@Inject
	private InstituicaoService instituicaoService;
	
	@RequestMapping("/cadastroInstituicao")
	public ModelAndView index(){
		mav.clear();
		mav.setViewName("cadastroInstituicao");
		return mav;
	}
	
	@RequestMapping(value="salvarInstituicao", method=RequestMethod.POST)
	public String salvarInstituicao(Instituicao instituicao){
		instituicaoService.cadastrarInstituicao(instituicao);
		return "redirect:/cadastroInstituicao";
	}
}
