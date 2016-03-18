package br.com.semear.gestao.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.semear.gestao.model.Instituicao;
import br.com.semear.gestao.service.InstituicaoService;
import br.com.semear.gestao.service.ProjetoService;
import br.com.semear.gestao.service.UnidadePrisionalService;
import br.com.semear.gestao.service.UsuarioService;

@Controller
@RequestMapping("/painel/instituicoes")
public class InstituicaoController {
	private ModelAndView mav = new ModelAndView();
	
	private String colaborador = "ROLE_COLABORADOR";
	private String coordenador = "ROLE_COORDENADOR";
	private String avaliadorInterno = "ROLE_AVALIADOR_INTERNO";
	private String avaliadorExterno = "ROLE_AVALIADOR_EXTERNO";
	
	@Inject
	private InstituicaoService instituicaoService;
	
	@Inject
	private ProjetoService projetoService;
	
	@Inject
	private UnidadePrisionalService unidadePrisionalService;
	
	@Inject
	private UsuarioService usuarioService;
	
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
		return mav;
	}
	
	@RequestMapping(value="salvarInstituicao", method=RequestMethod.POST)
	public ModelAndView salvarInstituicao(Instituicao instituicao){
		mav.clear();
		mav.setViewName("cadastroInstituicao");
		mav.addObject("msg",instituicaoService.cadastrarInstituicao(instituicao));
		mav.addObject("idInstituicao", instituicao.getId());
		return mav;
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
		mav.addObject("inst", instituicaoService.buscarInstituicaoPorId(idInstituicao));
		mav.addObject("users", usuarioService.buscarUsuarioPorInstituicao(idInstituicao));
		mav.addObject("unidades", unidadePrisionalService.buscarUnidadePrisionalPorInstituicao(idInstituicao));
		mav.addObject("unidadesPrisionais", unidadePrisionalService.listarUnidadesPorStatus(true));
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="consultarInstituicao", method=RequestMethod.POST)
	public boolean consultarInstituicao(String documento){
		boolean documentoExiste = false;
		
		if(instituicaoService.buscarInstituicaoPorDocumento(documento) != null){
			documentoExiste = true;
		}
		
		return documentoExiste;
		
	}
	
	@RequestMapping(value="adicionarUnidade", method=RequestMethod.POST)
	public String adicionarUnidade(long idInstituicao, long idUnidadePrisional){
		unidadePrisionalService.adicionarVinculoInstituicaoComUnidadePrisional(idInstituicao,idUnidadePrisional);
		return "redirect:/painel/instituicoes/editar/"+idInstituicao;
	}
}
