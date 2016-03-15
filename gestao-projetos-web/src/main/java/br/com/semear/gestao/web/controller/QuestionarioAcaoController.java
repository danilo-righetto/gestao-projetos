package br.com.semear.gestao.web.controller;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.semear.gestao.model.AlternativaPerguntaAcao;
import br.com.semear.gestao.model.PerguntaAcao;
import br.com.semear.gestao.model.QuestionarioAcao;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.QuestionarioAcaoService;

@Controller
@RequestMapping("/painel/questionariosacao")
@Scope(value=WebApplicationContext.SCOPE_SESSION)
public class QuestionarioAcaoController {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -7770365736587524256L;
	
	private ModelAndView mav = new ModelAndView();
	
	@Inject
	private QuestionarioAcaoService questionarioAcaoService;
	
	private QuestionarioAcao questionarioAcao;
	
	private List<PerguntaAcao> perguntasRemovidas;
	
	@RequestMapping("cadastro/{idAcao}")
	public ModelAndView formCadastro(@PathVariable("idAcao") long idAcao){
		try {
			mav.clear();
			perguntasRemovidas = new ArrayList<PerguntaAcao>();
			questionarioAcao = questionarioAcaoService.buscarQuestionarioPorIdAcao(idAcao);
			mav.setViewName("cadastroQuestionarioAcao");
			mav.addObject("questionario",questionarioAcao);
			mav.addObject("tiposPerguntas",questionarioAcaoService.listarTiposDePerguntas());
			
		} catch (Exception e) {
			mav.clear();
			mav.setViewName("redirect:/404");
		}
		
		return mav;
	}
	
	@RequestMapping("editar/{idAcao}")
	public ModelAndView formEditar(@PathVariable("idAcao") long idAcao,@ModelAttribute("mensagem") String mensagem){
		mav.clear();
		try {
		
			mav.setViewName("cadastroQuestionarioAcao");
			mav.addObject("questionario",questionarioAcao);
			mav.addObject("tiposPerguntas",questionarioAcaoService.listarTiposDePerguntas());
			mav.addObject("mensagem",mensagem);
		
		} catch (Exception e) {
			mav.clear();
			mav.setViewName("redirect:/404");
		}
		
		return mav;
	}
	
	@RequestMapping("salvarQuestionario")
	public String salvarQuestionario(){
		questionarioAcaoService.alterarQuestionario(this.questionarioAcao,perguntasRemovidas);
		return "redirect:/painel/questionariosacao/cadastro/"+this.questionarioAcao.getAcao().getId();
	}
	
	@RequestMapping("adicionarPerguntaAcao")
	public String adicionarPerguntaAcao(PerguntaAcao novaPergunta,String inputRespostaUnica,
			String[] alternativaRespostaMultipla,
			HttpSession session,RedirectAttributes redirectAttributes){
		
		if(!validarPergunta(novaPergunta)){
			
			novaPergunta.setDataCadastro(Calendar.getInstance());
			novaPergunta.setUsuario((Usuario)session.getAttribute("usuario"));
			if(novaPergunta.getTipoPergunta().getId() == 1){
				AlternativaPerguntaAcao alternativa = new AlternativaPerguntaAcao();
				alternativa.setDescricaoAlternativa(inputRespostaUnica);
				novaPergunta.getAlternativas().add(alternativa);
			}
			else if(novaPergunta.getTipoPergunta().getId() == 2){
				for(int i =0; i < alternativaRespostaMultipla.length; i++){
					AlternativaPerguntaAcao alternativa = new AlternativaPerguntaAcao();
					alternativa.setDescricaoAlternativa(alternativaRespostaMultipla[i]);
					novaPergunta.getAlternativas().add(alternativa);
				}
			}
			
			else if(novaPergunta.getTipoPergunta().getId() == 4){
				AlternativaPerguntaAcao alternativaSim = new AlternativaPerguntaAcao();
				alternativaSim.setDescricaoAlternativa("Sim");
				novaPergunta.getAlternativas().add(alternativaSim);
				
				AlternativaPerguntaAcao alternativaNao = new AlternativaPerguntaAcao();
				alternativaNao.setDescricaoAlternativa("Não");
				novaPergunta.getAlternativas().add(alternativaNao);
			}
			
			this.questionarioAcao.getPerguntas().add(novaPergunta);
			redirectAttributes.addFlashAttribute("mensagem","ADD");
		}else{
			redirectAttributes.addFlashAttribute("mensagem","ERRO_EXISTENTE");
		}
		return "redirect:/painel/questionariosacao/editar/"+this.questionarioAcao.getAcao().getId();
	}
	
	
	
	private boolean validarPergunta(PerguntaAcao novaPergunta) {
		boolean existe = false;
		for(PerguntaAcao p : questionarioAcao.getPerguntas()){
			if(p.getDescricaoPerguntaAcao().toUpperCase().equals(novaPergunta.getDescricaoPerguntaAcao().toUpperCase())){
				existe = true;
				break;
			}
		}
		return existe;
	}
	
	@RequestMapping("removerPergunta")
	public String removerPergunta(long idPergunta, String descricaoPergunta,RedirectAttributes redirectAttributes){
		PerguntaAcao pergunta = buscarPerguntaPorIdOuDescricao(idPergunta,descricaoPergunta);
		if(pergunta != null){
			this.questionarioAcao.getPerguntas().remove(pergunta);
			this.perguntasRemovidas.add(pergunta);
			redirectAttributes.addFlashAttribute("mensagem","REMOVE");
		}else{
			redirectAttributes.addFlashAttribute("mensagem","ERRO");
		}
		return "redirect:/painel/questionariosacao/editar/"+this.questionarioAcao.getAcao().getId();
	}
	
private PerguntaAcao buscarPerguntaPorIdOuDescricao(long idPergunta, String descricaoPergunta) {
		PerguntaAcao pergunta = null;
		for(PerguntaAcao p : questionarioAcao.getPerguntas()){
			if(idPergunta != 0 && idPergunta == p.getId()){
				pergunta = p;
				break;
			}
			else if(descricaoPergunta != null && descricaoPergunta.toUpperCase().equals(p.getDescricaoPerguntaAcao().toUpperCase())){
				pergunta = p;
				break;
			}
		}
		return pergunta;
	}
}
