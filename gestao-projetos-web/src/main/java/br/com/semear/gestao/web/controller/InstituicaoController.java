package br.com.semear.gestao.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.semear.gestao.model.Instituicao;
import br.com.semear.gestao.service.InstituicaoService;
import br.com.semear.gestao.service.ProjetoService;
import br.com.semear.gestao.service.UnidadePrisionalService;

@Controller
@RequestMapping("/painel/instituicoes")
public class InstituicaoController {
	private ModelAndView mav = new ModelAndView();
	
	@Inject
	private InstituicaoService instituicaoService;
	
	@Inject
	private ProjetoService projetoService;
	
	@Inject
	private UnidadePrisionalService unidadePrisionalService;
	
	@RequestMapping("/")
	public ModelAndView listaDeInstituicoes(){
		mav.clear();
		mav.setViewName("listarInstituicoes");
		mav.addObject("instituicoes", instituicaoService.listarInstituicoes());
		return mav;
	}
	
	
	@RequestMapping("cadastro")
	public ModelAndView index(){
		mav.clear();
		mav.setViewName("cadastroInstituicao");
		mav.addObject("listaprojetos", projetoService.listarTodosProjetos());
		mav.addObject("unidadesprisionais", unidadePrisionalService.listaUnidades());
		return mav;
	}
	
	@RequestMapping(value="salvarInstituicao", method=RequestMethod.POST)
	public String salvarInstituicao(Instituicao instituicao){
		instituicaoService.cadastrarInstituicao(instituicao);
		return "redirect:/painel";
	}
	
	@RequestMapping(value="editarInstituicao", method=RequestMethod.POST)
	public String editarInstituicao(Instituicao instituicao){
		instituicaoService.editarInstituicao(instituicao);
		return "redirect:/painel/instituicoes/";
	}
	
	@RequestMapping(value="editar/{idInstituicao}")
	public ModelAndView formEditar(@PathVariable("idInstituicao") long idInstituicao){
		mav.clear();
		mav.setViewName("editarInstituicao");
		mav.addObject("listaprojetos", projetoService.listarTodosProjetos());
		mav.addObject("unidadesprisionais", unidadePrisionalService.listaUnidades());
		mav.addObject("inst", instituicaoService.buscarInstituicaoPorId(idInstituicao));
		return mav;
	}
}
