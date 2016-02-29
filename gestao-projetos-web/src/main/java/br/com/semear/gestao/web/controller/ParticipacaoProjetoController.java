package br.com.semear.gestao.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.semear.gestao.model.ParticipacaoProjeto;
import br.com.semear.gestao.service.ParticipacaoProjetoService;
import br.com.semear.gestao.service.ProjetoService;

@Controller
public class ParticipacaoProjetoController {
	ModelAndView mav = new ModelAndView();
	
	@Inject
	private ParticipacaoProjetoService participacaoProjetoService;
	
	@Inject
	private ProjetoService projetoService;
	
	@RequestMapping("/cadastroParticipacaoProjeto")
	public ModelAndView index(){
		mav  = new ModelAndView("cadastroParticipacaoProjeto");
//		mav.addObject("projetos", projetoService.buscarProjetoPorNome(nome));
		
		return mav;
	}
	
	@RequestMapping("salvarParticipacaoProjeto")
	public String salvarParticipacaoProjeto(ParticipacaoProjeto participacaoProjeto) {
		participacaoProjetoService.cadastrar(participacaoProjeto);
		return "redirect:/cadastroParticipacaoProjeto";
	}
}
