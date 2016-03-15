package br.com.semear.gestao.web.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.semear.gestao.model.Projeto;
import br.com.semear.gestao.model.Reeducando;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.InstituicaoService;
import br.com.semear.gestao.service.ParticipacaoProjetoService;
import br.com.semear.gestao.service.ProjetoService;

@Controller
@RequestMapping("painel/participacao-projetos")
public class ParticipacaoProjetoController {
	ModelAndView mav = new ModelAndView();

	@Inject
	private ParticipacaoProjetoService participacaoProjetoService;

	@Inject
	private InstituicaoService instituicaoService;

	@Inject
	private ProjetoService projetoService;

	@RequestMapping("{idProjeto}/instituicoes/cadastroParticipacaoProjeto")
	public ModelAndView frmCadastro(@PathVariable("idProjeto") long idProjeto, Long[] idInstituicoes) {
		mav.clear();
		mav.setViewName("cadastroParticipacaoProjeto");
		mav.addObject("instituicoes", instituicaoService.buscarInstituicoesPorId(idInstituicoes));
		mav.addObject("colaboradores", participacaoProjetoService.listarColaboradoresDasInstituicoes(idInstituicoes, "ROLE_COLABORADOR"));
		mav.addObject("reeducandos", participacaoProjetoService.listarReeducandosPorUnidadePrisional(idProjeto));
		return mav;
	}

	@RequestMapping("/salvarParticipacaoProjeto")
	public String salvarParticipacaoProjeto(Long idProjeto, Long idCoordenador, Long[] idReeducandos, String[] funcoes,
			Long[] idColaboradores) {
		participacaoProjetoService.cadastrar(idProjeto, idCoordenador, idReeducandos, funcoes, idColaboradores);
		return "redirect:/painel/projetos/";
	}

	@RequestMapping("{idProjeto}/instituicoes")
	public ModelAndView formAssociarInstituicao(@PathVariable("idProjeto") long idProjeto) {
		Projeto projeto = projetoService.buscarProjetoPorId(idProjeto);
		mav.clear();
		mav.setViewName("associarProjetoInstituicao");
		mav.addObject("instituicoes",
				instituicaoService.buscarInstituicaoPorUnidade(projeto.getUnidadePrisional().getId()));
		return mav;
	}

	@ResponseBody
	@RequestMapping("/listarCoordenadores/{idInstituicao}/{idPerfil}")
	public List<Usuario> listarCoordenadores(@PathVariable("idInstituicao") long idInstituicao,
			@PathVariable("idPerfil") String idPerfil) {
		return participacaoProjetoService.listarCoPorInstituicao(idInstituicao, idPerfil);
	}
}