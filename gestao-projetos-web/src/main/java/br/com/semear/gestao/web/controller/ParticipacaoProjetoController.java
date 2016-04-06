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
import br.com.semear.gestao.service.ParceiroService;
import br.com.semear.gestao.service.ParticipacaoColaboradorProjetoService;
import br.com.semear.gestao.service.ParticipacaoParceiroProjetoService;
import br.com.semear.gestao.service.ParticipacaoProjetoService;
import br.com.semear.gestao.service.ProjetoService;

@Controller
@RequestMapping("painel/participacao-projetos")
public class ParticipacaoProjetoController {
	ModelAndView mav = new ModelAndView();

	@Inject
	private ParticipacaoProjetoService participacaoProjetoService;

	@Inject
	private ParticipacaoParceiroProjetoService participacaoParceiroProjetoService;

	@Inject
	private ParticipacaoColaboradorProjetoService participacaoColaboradorProjetoService;

	@Inject
	private ParceiroService parceiroService;

	@Inject
	private ProjetoService projetoService;
	
	@RequestMapping("{idProjeto}/parceiros/cadastroParticipacaoProjeto")
	public ModelAndView frmCadastro(@PathVariable("idProjeto") long idProjeto) {
		List<Long> parceirosAssociados = participacaoParceiroProjetoService.buscarParceirosAssociados(idProjeto);
		mav.clear();
		mav.setViewName("cadastroParticipacaoProjeto");
		mav.addObject("coordenadorProjeto", projetoService.buscarCoordenadorPorIdProjeto(idProjeto));
		mav.addObject("parceirosAssociados",
				participacaoParceiroProjetoService.listarParticipacaoParceirosProjeto(idProjeto));

		mav.addObject("reeducandosAssociados",
				participacaoProjetoService.listarParticipacaoReeducandoProjeto(idProjeto));
		mav.addObject("reeducandos", participacaoProjetoService.listarReeducandosPorUnidadePrisional(idProjeto));
		mav.addObject("colaboradoresAssociados",
				participacaoColaboradorProjetoService.listarColaboradoresDoProjeto(idProjeto, "ROLE_COLABORADOR"));

		mav.addObject("colaboradores",
				participacaoProjetoService.listarColaboradoresDosParceiros(parceirosAssociados, "ROLE_COLABORADOR"));

		return mav;
	}

	@RequestMapping("{idProjeto}/parceiros/salvarParticipacaoParceiroProjeto")
	public String salvarParticipacaoParceiroProjeto(@PathVariable("idProjeto") long idProjeto, Long[] idParceiros,
			RedirectAttributes redirectAttributes) {
		String msg = participacaoProjetoService.cadastrarParticipacaoParceiro(idProjeto, idParceiros);
		redirectAttributes.addFlashAttribute("msg", msg);
		return "redirect:/painel/participacao-projetos/" + idProjeto + "/parceiros";
	}

	@RequestMapping("/salvarParticipacaoProjeto")
	public String salvarParticipacaoProjeto(Long idProjeto, Long idCoordenador, Long[] idReeducandos, String[] funcoes,
			Long[] idColaboradores) {
		participacaoProjetoService.cadastrar(idProjeto, idCoordenador, idReeducandos, funcoes, idColaboradores);
		return "redirect:/painel/projetos/";
	}

	@RequestMapping("{idProjeto}/parceiros")
	public ModelAndView formAssociarParceiro(@PathVariable("idProjeto") long idProjeto,
			@ModelAttribute("msg") String msg) {
		Projeto projeto = projetoService.buscarProjetoPorId(idProjeto);
		mav.clear();
		mav.setViewName("associarProjetoParceiro");
		mav.addObject("msg", msg);
		mav.addObject("parceiros", parceiroService.buscarParceiroPorUnidade(projeto.getUnidadePrisional().getId()));
		mav.addObject("participacoes", participacaoProjetoService.listarParticipacaoParceirosProjeto(idProjeto));
		return mav;
	}

	@ResponseBody
	@RequestMapping("/listarCoordenadores/{idParceiro}/{idPerfil}")
	public List<Usuario> listarCoordenadoresDoParceiro(@PathVariable("idParceiro") long idParceiro,
			@PathVariable("idPerfil") String idPerfil) {
		return participacaoProjetoService.listarCoordenadoresDoParceiro(idParceiro, idPerfil);
	}
}