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

import br.com.semear.gestao.model.Pergunta;
import br.com.semear.gestao.model.Questionario;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.QuestionarioService;

@Controller
@RequestMapping("/painel/questionarios")
@Scope(value=WebApplicationContext.SCOPE_SESSION)
public class QuestionarioController {
	
	@Inject
	private QuestionarioService questionarioService;
	
	private ModelAndView mav = new ModelAndView();
	
	private Questionario questionario;
	private List<Pergunta> perguntasRemovidas;
	
	@RequestMapping("cadastro/{idProjeto}")
	public ModelAndView formCadastro(@PathVariable("idProjeto") long idProjeto){
		try {
			mav.clear();
			perguntasRemovidas = new ArrayList<Pergunta>();
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
	public ModelAndView formEditar(@PathVariable("idProjeto") long idProjeto,@ModelAttribute("mensagem") String mensagem){
		mav.clear();
		try {
		
			mav.setViewName("cadastroQuestionario");
			mav.addObject("questionario",questionario);
			mav.addObject("tiposPerguntas",questionarioService.listarTiposDePerguntas());
			mav.addObject("mensagem",mensagem);
		
		} catch (Exception e) {
			mav.clear();
			mav.setViewName("redirect:/404");
		}
		
		return mav;
	}
	
	@RequestMapping("salvarQuestionario")
	public String salvarQuestionario(){
		questionarioService.alterarQuestionario(this.questionario,perguntasRemovidas);
		return "redirect:/painel/questionarios/editar/"+this.questionario.getProjeto().getId();
	}
	
	@RequestMapping("adicionarPergunta")
	public String adicionarPergunta(Pergunta novaPergunta,HttpSession session,RedirectAttributes redirectAttributes){
		if(!validarPergunta(novaPergunta)){
			novaPergunta.setDataCadastro(Calendar.getInstance());
			novaPergunta.setUsuario((Usuario) session.getAttribute("usuario"));
			this.questionario.getPerguntas().add(novaPergunta);
			redirectAttributes.addFlashAttribute("mensagem","ADD");
		}else{
			redirectAttributes.addFlashAttribute("mensagem","ERRO_EXISTENTE");
		}
		return "redirect:/painel/questionarios/editar/"+this.questionario.getProjeto().getId();
	}
	
	@RequestMapping("removerPergunta")
	public String removerPergunta(long idPergunta, String descricaoPergunta,RedirectAttributes redirectAttributes){
		Pergunta pergunta = buscarPerguntaPorIdOuDescricao(idPergunta,descricaoPergunta);
		if(pergunta != null){
			this.questionario.getPerguntas().remove(pergunta);
			this.perguntasRemovidas.add(pergunta);
			redirectAttributes.addFlashAttribute("mensagem","REMOVE");
		}else{
			redirectAttributes.addFlashAttribute("mensagem","ERRO");
		}
		return "redirect:/painel/questionarios/editar/"+this.questionario.getProjeto().getId();
	}
	
	private Pergunta buscarPerguntaPorIdOuDescricao(long idPergunta, String descricaoPergunta) {
		Pergunta pergunta = null;
		for(Pergunta p : questionario.getPerguntas()){
			if(idPergunta != 0 && idPergunta == p.getId()){
				pergunta = p;
				break;
			}
			else if(descricaoPergunta != null && descricaoPergunta.toUpperCase().equals(p.getDescricaoPergunta().toUpperCase())){
				pergunta = p;
				break;
			}
		}
		return pergunta;
	}

	private boolean validarPergunta(Pergunta novaPergunta) {
		boolean existe = false;
		for(Pergunta p : questionario.getPerguntas()){
			if(p.getDescricaoPergunta().toUpperCase().equals(novaPergunta.getDescricaoPergunta().toUpperCase())){
				existe = true;
				break;
			}
		}
		return existe;
	}
}
