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

import br.com.semear.gestao.model.Projeto;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.ProjetoService;

@Controller
@RequestMapping("painel/projetos")
public class ProjetoController {

	@Inject
	private ProjetoService projetoService;
	
	private ModelAndView mav = new ModelAndView();
	
	@RequestMapping("/")
	public ModelAndView listaDeProjetos(){
		mav.clear();
		mav.setViewName("listar-projetos");
		mav.addObject("projetos", projetoService.listarTodosProjetos());
		return mav;
	}

	@RequestMapping("/cadastro")
	public String formCadastro() {
		return "cadastroProjeto";
	}

	@RequestMapping(value = "salvarProjeto", method = RequestMethod.POST)
	public String salvarProjeto(Projeto projeto, HttpSession session) {
		
		projeto.setUsuario((Usuario) session.getAttribute("usuario"));
		projetoService.cadastrarProjeto(projeto);
		return "redirect:/painel/projetos/";
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
