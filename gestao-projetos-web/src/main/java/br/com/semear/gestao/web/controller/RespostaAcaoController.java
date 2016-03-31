package br.com.semear.gestao.web.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.semear.gestao.model.QuestionarioAcao;
import br.com.semear.gestao.model.Reeducando;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.AcaoService;
import br.com.semear.gestao.service.QuestionarioAcaoService;
import br.com.semear.gestao.service.ReeducandoService;
import br.com.semear.gestao.service.RespostaAcaoService;

@Controller
@RequestMapping("painel/respostasacao")
public class RespostaAcaoController {
	ModelAndView mav = new ModelAndView();

	@Inject
	private AcaoService acaoService;
	
	@Inject
	private ReeducandoService reeducandoService;
	
	@Inject
	private QuestionarioAcaoService questionarioAcaoService;
	
	@Inject
	private RespostaAcaoService respostaAcaoService;
	
	private String statusAcao = "";
	
	@RequestMapping("/I/{idAcao}")
	public ModelAndView formCadastroInicio(@PathVariable("idAcao") long idAcao){
		try {
			statusAcao = "INICIO";
			mav.clear();
			QuestionarioAcao questionarioAcao = questionarioAcaoService.buscarQuestionarioPorIdAcao(idAcao);
			mav.setViewName("respostaAcao");
			mav.addObject("questionario",questionarioAcao);
			mav.addObject("tiposPerguntas",questionarioAcaoService.listarTiposDePerguntas());
			mav.addObject("reeducandos", reeducandoService.listarReeducandos());
			mav.addObject("status", statusAcao);
			
		} catch (Exception e) {
			mav.clear();
			mav.setViewName("redirect:/404");
		}
		
		return mav;
	}
	
	@RequestMapping("/F/{idAcao}")
	public ModelAndView formCadastroFim(@PathVariable("idAcao") long idAcao){
		try {
			statusAcao = "FIM";
			mav.clear();
			QuestionarioAcao questionarioAcao = questionarioAcaoService.buscarQuestionarioPorIdAcao(idAcao);
			mav.setViewName("respostaAcao");
			mav.addObject("questionario",questionarioAcao);
			mav.addObject("tiposPerguntas",questionarioAcaoService.listarTiposDePerguntas());
			mav.addObject("reeducandos", reeducandoService.listarReeducandos());
			mav.addObject("status", statusAcao);
			
		} catch (Exception e) {
			mav.clear();
			mav.setViewName("redirect:/404");
		}
		
		return mav;
	}
	
	@RequestMapping("salvarResposta")
	public String salvarResposta(String []respostas,Long idAcao,HttpSession session, Long reeducando, String respostaStatus){
		Usuario usuarioSessao = (Usuario) session.getAttribute("usuario");
		respostaAcaoService.salvarRespostaAcao(respostas,idAcao,usuarioSessao,reeducando,respostaStatus);
		return "redirect:/painel/";
	}
}
