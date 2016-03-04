package br.com.semear.gestao.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.semear.gestao.model.Reeducando;
import br.com.semear.gestao.service.ReeducandoService;
import br.com.semear.gestao.service.UnidadePrisionalService;

@Controller
@RequestMapping("painel/reeducandos")
public class ReeducandoController {
	private ModelAndView mav = new ModelAndView();

	@Inject
	private ReeducandoService reeducandoService;

	@Inject
	private UnidadePrisionalService unidadePrisionalService;

	@RequestMapping("/cadastro")
	public ModelAndView formCadastro() {
		mav.setViewName("cadastroReeducando");
		mav.addObject("unidades", unidadePrisionalService.listaUnidades());
		return mav;
	}

	@RequestMapping("/salvarReeducando")
	public String salvarReeducando(Reeducando reeducando) {
		reeducandoService.cadastrarReeducando(reeducando);
		return "redirect:/painel/reeducandos/";
	}

	@RequestMapping("/editar/{idReeducando}")
	public ModelAndView formEditar(@PathVariable("idReeducando") long idReeducando ) {
		mav.clear();
		mav.setViewName("editarReeducando");
		mav.addObject("reeducando", reeducandoService.buscarReeducandoPorId(idReeducando));
		mav.addObject("unidades", unidadePrisionalService.listaUnidades());
		return mav;
	}
	
	@RequestMapping("/editar")
	public String editarReeducando(Reeducando reeducando){
		reeducandoService.editarReeducando(reeducando);
		return "redirect:/painel/reeducandos/";
	}
	
	@RequestMapping("/")
	public ModelAndView listarReeducandos(){
		mav.clear();
		mav.setViewName("listarReeducandos");
		mav.addObject("reeducandos", reeducandoService.listarReeducandos());
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("/verificarMatricula")
	public boolean verificarMatricula(long matricula){
		return reeducandoService.verficarMatricula(matricula);
	}
}