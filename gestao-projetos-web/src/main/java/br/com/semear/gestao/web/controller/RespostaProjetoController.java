package br.com.semear.gestao.web.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.semear.gestao.model.Questionario;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.ProjetoService;
import br.com.semear.gestao.service.QuestionarioService;
import br.com.semear.gestao.service.RespostaProjetoService;

@Controller
@RequestMapping("painel/respostasprojeto")
public class RespostaProjetoController {
	ModelAndView mav = new ModelAndView();
	
	@SuppressWarnings("unused")
	@Inject
	private ProjetoService projetoService;
	
	@Inject
	private QuestionarioService questionarioService;
	
	@Inject
	private RespostaProjetoService respostaService;
	
	@RequestMapping("/{idProjeto}")
	public ModelAndView formCadastro(@PathVariable("idProjeto") long idProjeto){
		try {
			mav.clear();
			Questionario questionario = questionarioService.buscarQuestionarioPorIdProjeto(idProjeto);
			mav.setViewName("respostaProjeto");
			mav.addObject("questionario",questionario);
			mav.addObject("tiposPerguntas",questionarioService.listarTiposDePerguntas());
			
		} catch (Exception e) {
			mav.clear();
			mav.setViewName("redirect:/404");
		}
		
		return mav;
	}
	
	@RequestMapping("salvarResposta")
	public String salvarResposta(String []respostas,Long idProjeto,HttpSession session){
		Usuario usuarioSessao = (Usuario) session.getAttribute("usuario");
		respostaService.salvarResposta(respostas,idProjeto,usuarioSessao);
		return "redirect:/painel/respostasprojeto/"+idProjeto;
	}
}
