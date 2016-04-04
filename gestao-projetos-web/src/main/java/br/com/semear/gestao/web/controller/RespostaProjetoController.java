package br.com.semear.gestao.web.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.semear.gestao.model.Questionario;
import br.com.semear.gestao.model.Resposta;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.ParticipacaoProjetoService;
import br.com.semear.gestao.service.ProjetoService;
import br.com.semear.gestao.service.QuestionarioService;
import br.com.semear.gestao.service.ReeducandoService;
import br.com.semear.gestao.service.RespostaProjetoService;

@Controller
@RequestMapping("painel/respostasprojeto")
public class RespostaProjetoController {
	ModelAndView mav = new ModelAndView();
	
	@SuppressWarnings("unused")
	@Inject
	private ProjetoService projetoService;
	
	@Inject
	private ReeducandoService reeducandoService;
	
	@Inject
	private ParticipacaoProjetoService participacaoProjetoService;
	
	@Inject
	private QuestionarioService questionarioService;
	
	@Inject
	private RespostaProjetoService respostaService;
	
	private String statusProjeto = "";
	
	@RequestMapping("/I/{idProjeto}")
	public ModelAndView formCadastroInicio(@PathVariable("idProjeto") long idProjeto){
		try {
			statusProjeto = "INICIO";
			mav.clear();
			Questionario questionario = questionarioService.buscarQuestionarioPorIdProjeto(idProjeto);
			mav.setViewName("respostaProjeto");
			mav.addObject("questionario",questionario);
			mav.addObject("tiposPerguntas",questionarioService.listarTiposDePerguntas());
			mav.addObject("reeducandos", reeducandoService.listarReeducandos());
			mav.addObject("reeducandosAssociados", participacaoProjetoService.listarParticipacaoReeducandoProjeto(idProjeto));
			mav.addObject("status", statusProjeto);
			mav.addObject("respostas", respostaService.listarRespostas());
			
		} catch (Exception e) {
			mav.clear();
			mav.setViewName("redirect:/404");
		}
		
		return mav;
	}
	
	@RequestMapping("/F/{idProjeto}")
	public ModelAndView formCadastroFim(@PathVariable("idProjeto") long idProjeto){
		try {
			statusProjeto = "FIM";
			mav.clear();
			Questionario questionario = questionarioService.buscarQuestionarioPorIdProjeto(idProjeto);
			mav.setViewName("respostaProjeto");
			mav.addObject("questionario",questionario);
			mav.addObject("tiposPerguntas",questionarioService.listarTiposDePerguntas());
			mav.addObject("reeducandos", reeducandoService.listarReeducandos());
			mav.addObject("reeducandosAssociados", participacaoProjetoService.listarParticipacaoReeducandoProjeto(idProjeto));
			mav.addObject("status", statusProjeto);
			
		} catch (Exception e) {
			mav.clear();
			mav.setViewName("redirect:/404");
		}
		
		return mav;
	}
	
	@RequestMapping("salvarResposta")
	public String salvarResposta(String []respostas,Long idProjeto,HttpSession session, Long reeducando, String tipo){
		Usuario usuarioSessao = (Usuario) session.getAttribute("usuario");
		respostaService.salvarResposta(respostas,idProjeto,usuarioSessao,reeducando,tipo);
		//return "redirect:/painel/respostasProjeto/"+idProjeto;
		return "redirect:/painel/";
	}
	
	@ResponseBody
	@RequestMapping(value = "consultarReeducando", method = RequestMethod.POST)
	public List<Resposta> consultarReeducando(long idReeducando, Long idProjeto, String tipo) {
		List<Resposta> respostas = respostaService.listarRespostasReeducandoPorProjetoTipo(idReeducando, idProjeto, tipo);
			return respostas;
	}
}
