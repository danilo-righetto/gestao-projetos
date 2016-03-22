package br.com.semear.gestao.web.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.semear.gestao.model.QuestionarioAcao;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.AcaoService;
import br.com.semear.gestao.service.QuestionarioAcaoService;
import br.com.semear.gestao.service.RespostaAcaoService;

@Controller
@RequestMapping("painel/respostas")
public class RespostaAcaoController {
	ModelAndView mav = new ModelAndView();

	@Inject
	private AcaoService acaoService;
	
	@Inject
	private QuestionarioAcaoService questionarioAcaoService;
	
	@Inject
	private RespostaAcaoService respostaAcaoService;
	
	@RequestMapping("/{idAcao}")
	public ModelAndView formCadastro(@PathVariable("idAcao") long idAcao){
		try {
			mav.clear();
			QuestionarioAcao questionarioAcao = questionarioAcaoService.buscarQuestionarioPorIdAcao(idAcao);
			mav.setViewName("respostaAcao");
			mav.addObject("questionario",questionarioAcao);
			mav.addObject("tiposPerguntas",questionarioAcaoService.listarTiposDePerguntas());
			
		} catch (Exception e) {
			mav.clear();
			mav.setViewName("redirect:/404");
		}
		
		return mav;
	}
	
	@RequestMapping("salvarResposta")
	public String salvarResposta(String []respostas,Long idAcao,HttpSession session){
		Usuario usuarioSessao = (Usuario) session.getAttribute("usuario");
		respostaAcaoService.salvarRespostaAcao(respostas,idAcao,usuarioSessao);
		return "redirect:/painel/respostas/"+idAcao;
	}
}
