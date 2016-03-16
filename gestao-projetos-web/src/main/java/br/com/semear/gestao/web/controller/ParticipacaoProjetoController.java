package br.com.semear.gestao.web.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.semear.gestao.model.Projeto;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.InstituicaoService;
import br.com.semear.gestao.service.ParticipacaoColaboradorProjetoService;
import br.com.semear.gestao.service.ParticipacaoInstituicaoProjetoService;
import br.com.semear.gestao.service.ParticipacaoProjetoService;
import br.com.semear.gestao.service.ProjetoService;

@Controller
@RequestMapping("painel/participacao-projetos")
public class ParticipacaoProjetoController {
	ModelAndView mav = new ModelAndView();

	@Inject
	private ParticipacaoProjetoService participacaoProjetoService;
	
	@Inject
	private ParticipacaoInstituicaoProjetoService participacaoInstituicaoProjetoService;
	
	@Inject
	private ParticipacaoColaboradorProjetoService participacaoColaboradorProjetoService;

	@Inject
	private InstituicaoService instituicaoService;

	@Inject
	private ProjetoService projetoService;
	
	@RequestMapping("{idProjeto}/instituicoes/cadastroParticipacaoProjeto")
	public ModelAndView frmCadastro(@PathVariable("idProjeto") long idProjeto) {
		List<Long> instituicoesAssociadas = participacaoInstituicaoProjetoService.buscarInstituicoesAssociadas(idProjeto);
		mav.clear();
		mav.setViewName("cadastroParticipacaoProjeto");
		mav.addObject("coordernadorProjeto", projetoService.buscarCoodernadorPorIdProjeto(idProjeto));
		mav.addObject("instituicoesAssociadas", participacaoInstituicaoProjetoService.listarParticipacaoInstituicoesProjeto(idProjeto));
		
		mav.addObject("reeducandosAssociados", participacaoProjetoService.listarParticipacaoReeducandoProjeto(idProjeto));
		mav.addObject("reeducandos", participacaoProjetoService.listarReeducandosPorUnidadePrisional(idProjeto));
		mav.addObject("colaboradoresAssociados",
				participacaoColaboradorProjetoService.listarParticipacaoProjetos(idProjeto));
		
		mav.addObject("colaboradores",
				participacaoProjetoService.listarColaboradoresDasInstituicoes(instituicoesAssociadas, "ROLE_COLABORADOR"));
		
		return mav;
	}
	
	@RequestMapping("{idProjeto}/instituicoes/salvarParticipacaoInstituicaoProjeto")
	public String salvarParticipacaoInstituicaoProjeto(@PathVariable("idProjeto") long idProjeto, Long[] idInstituicoes,
			RedirectAttributes redirectAttributes) {
		String msg = participacaoProjetoService.cadastrarParticipacaoInstituicao(idProjeto, idInstituicoes);
		redirectAttributes.addFlashAttribute("msg", msg);
		return "redirect:/painel/participacao-projetos/"+idProjeto+"/instituicoes";
	}

	@RequestMapping("/salvarParticipacaoProjeto")
	public String salvarParticipacaoProjeto(Long idProjeto, Long idCoordenador,
			Long[] idReeducandos, String[] funcoes, Long[] idColaboradores) {
		participacaoProjetoService.cadastrar(idProjeto, idCoordenador, idReeducandos, funcoes, idColaboradores);
		return "redirect:/painel/projetos/";
	}

	@RequestMapping("{idProjeto}/instituicoes")
	public ModelAndView formAssociarInstituicao(@PathVariable("idProjeto") long idProjeto, @ModelAttribute("msg") String msg) {
		Projeto projeto = projetoService.buscarProjetoPorId(idProjeto);
		mav.clear();
		mav.setViewName("associarProjetoInstituicao");
		mav.addObject("msg", msg);
		mav.addObject("instituicoes",
				instituicaoService.buscarInstituicaoPorUnidade(projeto.getUnidadePrisional().getId()));
		mav.addObject("participacoes", participacaoProjetoService.listarParticipacaoInstituicoesProjeto(idProjeto));
		return mav;
	}

	@ResponseBody
	@RequestMapping("/listarCoordenadores/{idInstituicao}/{idPerfil}")
	public List<Usuario> listarCoordenadores(@PathVariable("idInstituicao") long idInstituicao,
			@PathVariable("idPerfil") String idPerfil) {
		return participacaoProjetoService.listarCoPorInstituicao(idInstituicao, idPerfil);
	}
}