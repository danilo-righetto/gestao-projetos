package br.com.semear.gestao.web.controller;

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

import br.com.semear.gestao.service.UsuarioService;

@Controller
@SessionAttributes(value = { "usuario" })
public class PainelController {

	private ModelAndView mav = new ModelAndView();

	@Inject
	private UsuarioService usuarioService;

	@RequestMapping("/painel")
	public ModelAndView index(HttpServletRequest req, Model model) {
		this.mav.clear();
		mav.setViewName("403");
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		/** VERIFICA PERFIL DO USUARIO LOGADO */
		for (GrantedAuthority g : user.getAuthorities()) {

			if (g.getAuthority().equals("ROLE_ADMINISTRADOR")
					|| g.getAuthority().equals("ROLE_COORDENADOR")
					|| g.getAuthority().equals("ROLE_COLABORADOR")
					|| g.getAuthority().equals("ROLE_REEDUCANDO")
					|| g.getAuthority().equals("ROLE_ESTAGIARIO")
					|| g.getAuthority().equals("ROLE_AVALIADOR_INTERNO")
					|| g.getAuthority().equals("ROLE_AVALIADOR_EXTERNO")
					|| g.getAuthority().equals("ROLE_USUARIO")) {
				mav.setViewName("painel");
				break;
			}
		}
		/** SETA DADOS DO USUARIO NA SESSAO */
		if (!model.containsAttribute("usuario")) {
			model.addAttribute("usuario",usuarioService.buscarUsuarioPorLogin(user.getUsername()));
		}
		
		return mav;
	}
}
