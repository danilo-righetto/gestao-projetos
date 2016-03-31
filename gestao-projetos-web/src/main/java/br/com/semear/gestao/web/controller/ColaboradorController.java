package br.com.semear.gestao.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.semear.gestao.service.InstituicaoService;

@Controller
@RequestMapping("/painel/colaboradores")
public class ColaboradorController {
	private ModelAndView mav = new ModelAndView();

	@Inject
	private InstituicaoService instituicaoService;

	
}
