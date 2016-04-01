package br.com.semear.gestao.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/")
	public String login(HttpServletRequest request){
		
		/**VERIFICA SE EXISTE SESSÃO PARA O USUARIO, CASO EXISTA REDIRECIONA PARA O PAINEL, SENÃO VAI PARA TELA DE LOGIN*/
		if(!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
			return "redirect:/painel";
		}
		return "login";
	}
}
