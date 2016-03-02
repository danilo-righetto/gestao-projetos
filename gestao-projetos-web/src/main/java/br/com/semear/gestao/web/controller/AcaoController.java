package br.com.semear.gestao.web.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.semear.gestao.model.Acao;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.AcaoService;

@Controller
@RequestMapping("painel/acoes")
public class AcaoController {
	ModelAndView mav = new ModelAndView();

	@Inject
	private AcaoService acaoService;

	@RequestMapping("/cadastrar")
	public String formCadastro() {
		return "cadastrarAcao";
	}

	@RequestMapping("/salvarAcao")
	public String salvarAcao(Acao acao, HttpSession session) {
		acao.setUsuario((Usuario) session.getAttribute("usuario"));
		acaoService.cadastrar(acao);
		return "redirect:/painel/acoes";
	}

	@RequestMapping("/editar/{idAcao}")
	public ModelAndView formEditar(@PathVariable("idAcao") long idAcao) {
		mav.clear();
		mav.setViewName("editarAcao");
		mav.addObject("acao", acaoService.buscarAcaoPorId(idAcao));
		return mav;
	}

	@RequestMapping("editarAcao")
	public String editarAcao(Acao acao) {
		acaoService.editar(acao);
		return "redirect:/painel/acoes";
	}

	@RequestMapping
	public ModelAndView listarAcoes() {
		mav.clear();
		mav.setViewName("listarAcoes");
		mav.addObject("acoes", acaoService.listarAcoes());
		return mav;
	}
}