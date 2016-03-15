package br.com.semear.gestao.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.semear.gestao.model.PerguntaAcao;
import br.com.semear.gestao.model.QuestionarioAcao;
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
	
	private QuestionarioAcao questionarioAcao;
	
	private List<PerguntaAcao> perguntasRemovidas;
	
	@Inject
	private RespostaAcaoService respostaAcaoService;

	@RequestMapping("/")
	public ModelAndView listarAcoes() {
		mav.clear();
		mav.setViewName("respostaAcao");
		return mav;
	}
	
	@RequestMapping("/{idAcao}")
	public ModelAndView formCadastro(@PathVariable("idAcao") long idAcao){
		try {
			mav.clear();
			perguntasRemovidas = new ArrayList<PerguntaAcao>();
			questionarioAcao = questionarioAcaoService.buscarQuestionarioPorIdAcao(idAcao);
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
	public String salvarResposta(String []respostas){
		//respostaAcaoService.salvarRespostaAcao(respostas);
		questionarioAcaoService.alterarQuestionario(this.questionarioAcao,perguntasRemovidas);
		return "redirect:/painel/questionariosacao/cadastro/"+this.questionarioAcao.getAcao().getId();
	}
}
