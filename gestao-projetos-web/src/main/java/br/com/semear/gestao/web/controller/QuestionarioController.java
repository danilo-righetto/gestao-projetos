package br.com.semear.gestao.web.controller;

import java.util.Calendar;

import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.semear.gestao.model.Pergunta;
import br.com.semear.gestao.model.Questionario;
import br.com.semear.gestao.service.QuestionarioService;

@Controller
@RequestMapping("/painel/questionarios")
@Scope(value=WebApplicationContext.SCOPE_SESSION)
public class QuestionarioController {
	
	@Inject
	private QuestionarioService questionarioService;
	
	private ModelAndView mav = new ModelAndView();
	
	private Questionario questionario;
	
	@RequestMapping("cadastro/{idProjeto}")
	public ModelAndView formCadastro(@PathVariable("idProjeto") long idProjeto){
		mav.clear();
		try {
			questionario = questionarioService.buscarQuestionarioPorIdProjeto(idProjeto);
			
			mav.setViewName("cadastroQuestionario");
			mav.addObject("questionario",questionario);
			mav.addObject("tiposPerguntas",questionarioService.listarTiposDePerguntas());
			
			
			
		} catch (Exception e) {
			mav.clear();
			mav.setViewName("redirect:/404");
		}
		
		return mav;
	}
	
	@RequestMapping("editar/{idProjeto}")
	public ModelAndView formEditar(@PathVariable("idProjeto") long idProjeto){
		mav.clear();
		try {
		
			mav.setViewName("cadastroQuestionario");
			mav.addObject("questionario",questionario);
			mav.addObject("tiposPerguntas",questionarioService.listarTiposDePerguntas());
		
		} catch (Exception e) {
			mav.clear();
			mav.setViewName("redirect:/404");
		}
		
		return mav;
	}
	
	@RequestMapping("adicionarPergunta")
	public String adicionarPergunta(Pergunta novaPergunta){
		novaPergunta.setDataCadastro(Calendar.getInstance());
		this.questionario.getPerguntas().add(novaPergunta);
		return "redirect:/painel/questionarios/editar/"+this.questionario.getProjeto().getId();
	}
}
