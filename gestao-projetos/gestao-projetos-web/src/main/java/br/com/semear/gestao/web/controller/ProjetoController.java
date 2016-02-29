package br.com.semear.gestao.web.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.com.semear.gestao.model.Projeto;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.ProjetoService;

@SessionAttributes({ "usuario" })
@Controller
@RequestMapping("painel/projetos")
public class ProjetoController {

	@Inject
	private ProjetoService projetoService;

	@RequestMapping("/cadastro")
	public String formCadastro() {
		return "cadastroProjeto";
	}

	@RequestMapping(value = "salvarProjeto", method = RequestMethod.POST)
	public String salvarProjeto(Projeto projeto, @ModelAttribute("usuario") Usuario usuario) {
		projeto.setUsuario(usuario);
		projetoService.cadastrarProjeto(projeto);
		return "redirect:/cadastroProjeto";
	}
	
	@ResponseBody
	@RequestMapping("/listarProjetos")
	public List<Projeto> listarProjetos(){
		return projetoService.listarTodosProjetos();
	}
}
