package br.com.semear.gestao.web.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.com.semear.gestao.model.Projeto;
import br.com.semear.gestao.service.ProjetoService;
import br.com.semear.gestao.service.UsuarioService;

@Controller
@SessionAttributes(value = { "usuario" })
public class PainelController {

	private ModelAndView mav = new ModelAndView();

	@Inject
	private UsuarioService usuarioService;
	
	@Inject
	private ProjetoService projetoService;

	@RequestMapping("/painel")
	public ModelAndView index(HttpServletRequest req, Model model) {
		this.mav.clear();
		mav.setViewName("403");
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		/** VERIFICA PERFIL DO USUARIO LOGADO */
		for (GrantedAuthority g : user.getAuthorities()) {
			 boolean valido = verificaPerfil(g.getAuthority(), mav);
			 if(valido){
				 break;
			 }
		}
		/** SETA DADOS DO USUARIO NA SESSAO */
		if (!model.containsAttribute("usuario")) {
			model.addAttribute("usuario",usuarioService.buscarUsuarioPorLogin(user.getUsername()));
		}
		
		return mav;
	}

	private boolean verificaPerfil(String perfil, ModelAndView mav ) {
		boolean valido = false;
		if (perfil.equals("ROLE_ADMINISTRADOR")){
			List<Projeto> projetos = projetoService.listarTodosProjetos();
			List<Integer> progressoProjetos = projetoService.calcularProgresso(projetos);
			mav.addObject("projetos",projetos);
			mav.addObject("progressos",progressoProjetos);
			this.mav.setViewName("painel-administrador");
			valido = true;
		}
		else if(perfil.equals("ROLE_COORDENADOR")){
			//TODO:BUSCA TODOS OS PROJETOS ONDE O USUÁRIO E O COODERNADOR
			this.mav.setViewName("painel-coordenador");
			valido = true;
		}
		else if(perfil.equals("ROLE_COLABORADOR")){
			//TODO: BUSCAR AS TAREFAS DO COLABORADOR
			this.mav.setViewName("painel-colaborador");
			valido = true;
		}
		else if(perfil.equals("ROLE_REEDUCANDO")){
			//TODO:POR ENQUANTO DEIXAR O ACESSO NEGADO
		}
		else if(perfil.equals("ROLE_ESTAGIARIO")){
			//TODO: BUSCAR AS TAREFAS DO ESTAGIARIO
			this.mav.setViewName("painel-estagiario");
			valido = true;
		}
		else if(perfil.equals("ROLE_AVALIADOR_INTERNO")){
			//TODO:POR ENQUANTO DEIXAR O ACESSO NEGADO
		}
		else if(perfil.equals("ROLE_AVALIADOR_EXTERNO")){
			//TODO:POR ENQUANTO DEIXAR O ACESSO NEGADO
		}
		else if(perfil.equals("ROLE_USUARIO")) {
			this.mav.setViewName("painel");
			valido = true;
		}	
		return valido;
	}
}
