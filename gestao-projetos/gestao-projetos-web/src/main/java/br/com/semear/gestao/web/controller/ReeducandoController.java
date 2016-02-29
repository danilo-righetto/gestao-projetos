package br.com.semear.gestao.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.semear.gestao.model.Reeducando;
import br.com.semear.gestao.service.ReeducandoService;
import br.com.semear.gestao.service.UnidadePrisionalService;

@Controller
public class ReeducandoController {
	private ModelAndView mav = new ModelAndView();

	@Inject
	private ReeducandoService reeducandoService;
	
	@Inject
	private UnidadePrisionalService unidadePrisionalService;

	@RequestMapping("/cadastroReeducando")
	public ModelAndView index() {
		mav.setViewName("cadastroReeducando");
		mav.addObject("unidades", unidadePrisionalService.listaUnidades());
		return mav;
	}

	@RequestMapping(value = "/salvarReeducando", method = RequestMethod.POST)
	public String salvarReeducando(Reeducando reeducando) {
		reeducandoService.cadastrarReeducando(reeducando);
		return "redirect:/cadastroReeducando";
	}
}
