package br.com.semear.gestao.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.semear.gestao.model.Colaborador;
import br.com.semear.gestao.model.Parceiro;
import br.com.semear.gestao.service.ColaboradorService;
import br.com.semear.gestao.service.ParceiroService;
import br.com.semear.gestao.service.UnidadePrisionalService;

@Controller
@RequestMapping("/painel/parceiros")
public class ParceiroController {
	private ModelAndView mav = new ModelAndView();

	private String colaborador = "ROLE_COLABORADOR";
	private String coordenador = "ROLE_COORDENADOR";
	private String avaliadorInterno = "ROLE_AVALIADOR_INTERNO";
	private String avaliadorExterno = "ROLE_AVALIADOR_EXTERNO";

	@Inject
	private ParceiroService parceiroService;

	@Inject
	private UnidadePrisionalService unidadePrisionalService;

	@Inject
	private ColaboradorService colaboradorService;

	@RequestMapping("/")
	public ModelAndView listaDeParceiros() {
		mav.clear();
		mav.setViewName("listarParceiros");
		mav.addObject("parceiros", parceiroService.listarParceiros());
		return mav;
	}

	@RequestMapping("cadastro")
	public ModelAndView frmCadastroParceiro() {
		mav.clear();
		mav.setViewName("cadastroParceiro");
		return mav;
	}

	@RequestMapping(value = "salvarParceiro", method = RequestMethod.POST)
	public ModelAndView salvarParceiro(Parceiro parceiro) {
		mav.clear();
		mav.setViewName("cadastroParceiro");
		mav.addObject("msg", parceiroService.cadastrarParceiro(parceiro));
		mav.addObject("idParceiro", parceiro.getId());
		return mav;
	}

	@RequestMapping(value = "editarParceiro", method = RequestMethod.POST)
	public String editarParceiro(Parceiro parceiro) {
		parceiroService.editarParceiro(parceiro);
		return "redirect:/painel/parceiros/";
	}

	@RequestMapping(value = "editar/{idParceiro}")
	public ModelAndView formEditarParceiro(@PathVariable("idParceiro") long idParceiro) {
		mav.clear();
		mav.setViewName("editarParceiro");
		mav.addObject("parceiro", parceiroService.buscarParceiroPorId(idParceiro));
		mav.addObject("unidades", unidadePrisionalService.buscarUnidadePrisionalPorParceiro(idParceiro));
		mav.addObject("unidadesPrisionais", unidadePrisionalService.listarUnidadesPorStatus(true));
		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "consultarParceiro", method = RequestMethod.POST)
	public boolean consultarParceiro(String documento) {
		boolean documentoExiste = false;

		if (parceiroService.buscarParceiroPorDocumento(documento) != null) {
			documentoExiste = true;
		}
		return documentoExiste;
	}

	@RequestMapping(value = "adicionarUnidade", method = RequestMethod.POST)
	public String adicionarUnidade(long idParceiro, long idUnidadePrisional) {
		unidadePrisionalService.adicionarVinculoParceiroComUnidadePrisional(idParceiro, idUnidadePrisional);
		return "redirect:/painel/parceiros/editar/" + idParceiro;
	}

	@RequestMapping("{idParceiro}/colaboradores/cadastro")
	public ModelAndView frmCadastroColaborador(@PathVariable long idParceiro) {
		mav.setViewName("cadastroColaborador");

		return mav;
	}

	@RequestMapping("{idParceiro}/salvarColaborador")
	public String cadastrarColaborador(@PathVariable long idParceiro, Colaborador colaborador) {
		colaboradorService.cadastrar(colaborador);
		return "redirect:colaboradores";
	}

	@RequestMapping("{idParceiro}/colaboradores/{idColaborador}/editar")
	public ModelAndView frmEditarColaborador(@PathVariable long idColaborador, @PathVariable long idParceiro) {
		mav.clear();
		mav.setViewName("editarColaborador");
		mav.addObject("colaborador", colaboradorService.buscarColaboradorPorId(idColaborador));
		return mav;
	}

	@RequestMapping("{idParceiro}/editarColaborador")
	public String editarColaborador(@PathVariable long idParceiro, Colaborador colaborador) {
		colaboradorService.editar(colaborador);
		return "redirect:colaboradores";
	}

	@RequestMapping("{idParceiro}/colaboradores")
	public ModelAndView listarColaboradores(@PathVariable long idParceiro) {
		mav.clear();
		mav.setViewName("listarColaborador");
		mav.addObject("colaboradores", colaboradorService.listarColaboradores(idParceiro));

		return mav;
	}
}