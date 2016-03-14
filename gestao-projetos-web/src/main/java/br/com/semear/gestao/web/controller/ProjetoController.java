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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.semear.gestao.model.Projeto;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.ProjetoService;
import br.com.semear.gestao.service.UnidadePrisionalService;

@Controller
@RequestMapping("painel/projetos")
public class ProjetoController {

	@Inject
	private ProjetoService projetoService;
	
	@Inject
	private UnidadePrisionalService unidadePrisionalService;
	
	private ModelAndView mav = new ModelAndView();
	
	@RequestMapping("/")
	public ModelAndView listaDeProjetos(){
		mav.clear();
		mav.setViewName("listar-projetos");
		mav.addObject("projetos", projetoService.listarTodosProjetos());
		return mav;
	}

	@RequestMapping("/cadastro")
	public ModelAndView formCadastro() {
		mav.clear();
		mav.setViewName("cadastroProjeto");
		mav.addObject("unidadesPrisionais", unidadePrisionalService.listaUnidades());
		
		return mav;
	}

	@RequestMapping(value = "salvarProjeto", method = RequestMethod.POST)
	public ModelAndView salvarProjeto(Projeto novoProjeto, HttpSession session, RedirectAttributes redirectAttributes) {
		
		novoProjeto.setUsuario((Usuario) session.getAttribute("usuario"));
		String msg = projetoService.cadastrarProjeto(novoProjeto);
		
		mav.clear();
		mav.setViewName("cadastroProjeto");
		mav.addObject("idProjeto", novoProjeto.getId());
		mav.addObject("msg", msg);
		return mav;
	}
	
	@RequestMapping(value="editar/{idProjeto}")
	public ModelAndView formEditar(@PathVariable("idProjeto") long idProjeto){
		mav.clear();
		mav.setViewName("editarProjeto");
		mav.addObject("projeto", projetoService.buscarProjetoPorId(idProjeto));
		return mav;
	}
	
	@RequestMapping(value = "editarProjeto", method = RequestMethod.POST)
	public String editarProjeto(Projeto projeto) {
		projetoService.editarProjeto(projeto);
		return "redirect:/painel/projetos/";
	}
	
	@ResponseBody
	@RequestMapping("/listarProjetos")
	public List<Projeto> listarProjetos(){
		return projetoService.listarTodosProjetos();
	}
}
