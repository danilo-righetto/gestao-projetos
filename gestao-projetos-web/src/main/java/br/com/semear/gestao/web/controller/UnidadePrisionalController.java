package br.com.semear.gestao.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.semear.gestao.model.UnidadePrisional;
import br.com.semear.gestao.service.UnidadePrisionalService;

@Controller
@RequestMapping("painel/unidades-prisionais")
public class UnidadePrisionalController {

	ModelAndView mav = new ModelAndView();

	@Inject
	private UnidadePrisionalService unidadePrisionalService;

	@RequestMapping("/cadastrar")
	public String formCadastrar() {
		return "cadastrarUnidadePrisional";
	}

	@RequestMapping("/salvarUnidadePrisional")
	public String salvarUnidadePrisional(UnidadePrisional unidadePrisional) {
		unidadePrisionalService.cadastrar(unidadePrisional);
		return "redirect:/painel/unidades-prisionais/";
	}

	@RequestMapping("/editar/{idUnidadePrisional}")
	public ModelAndView formEditar(@PathVariable("idUnidadePrisional") long idUnidadePrisional) {
		mav.clear();
		mav.setViewName("editarUnidadePrisional");
		mav.addObject("unidadePrisional", unidadePrisionalService.buscarUnidadePrisionalPorId(idUnidadePrisional));

		return mav;
	}

	@RequestMapping("/editarUnidadePrisional")
	public String editarUnidadePrisional(UnidadePrisional unidadePrisional) {
		unidadePrisionalService.editar(unidadePrisional);
		return "redirect:/painel/unidades-prisionais/";
	}

	@RequestMapping("/")
	public ModelAndView listarUnidadesPrisionais() {
		mav.clear();
		mav.setViewName("listarUnidadesPrisionais");
		mav.addObject("unidades", unidadePrisionalService.listaUnidades());
		return mav;
	}
}