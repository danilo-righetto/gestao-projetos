package br.com.semear.gestao.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/painel/questionarios")
public class QuestionarioController {
	
	private ModelAndView mav = new ModelAndView();
	
	@RequestMapping("/")
	public String listarQuestionarios(){
		return "";
	}
	
	@RequestMapping("cadastro")
	public ModelAndView formCadastro(){
		mav.clear();
		mav.setViewName("cadastroQuestionario");
		return mav;
	}

}
