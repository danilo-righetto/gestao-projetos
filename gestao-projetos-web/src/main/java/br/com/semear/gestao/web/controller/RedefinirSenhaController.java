package br.com.semear.gestao.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.UsuarioService;

@Controller
public class RedefinirSenhaController {
	
	@Inject
	private UsuarioService usuarioService;
	
	private ModelAndView mav = new ModelAndView();
	
	@RequestMapping("/esqueceu-senha")
	private ModelAndView esqueceuSenha(@ModelAttribute("mensagem") String mensagem){
		mav.clear();
		mav.setViewName("esqueceu-senha");
		mav.addObject("mensagem", mensagem);
		return mav;
	}
	
	@RequestMapping("/enviar-senha")
	private String esqueceuSenha(String email,final RedirectAttributes redirectAttributes){
		redirectAttributes.addFlashAttribute("mensagem", usuarioService.enviarEmailNovaSenha(email));
		return "redirect:/esqueceu-senha";
	}
	
	@RequestMapping("/redefinir-senha/{hash}")
	private ModelAndView redefinirSenha(@PathVariable("hash") String hash,@ModelAttribute("mensagem") String mensagem){
		mav.clear();
		
		Usuario usuario = usuarioService.buscarUsuarioRedefinirSenha(hash);
		mav.addObject("mensagem", mensagem);
		if(mensagem.equals("OK") || usuario != null){
			mav.setViewName("redefinir-senha");
			mav.addObject("user", usuario);
			mav.addObject("hash", hash);
		}else{
			mav.setViewName("404");
		}
		
		return mav;
	}
	
	@RequestMapping("/salvar-nova-senha")
	private String salvarNovaSenha(String novaSenha,
				String confirmaNovaSenha,String email,String hash,
				final RedirectAttributes redirectAttributes){

		String mensagem = usuarioService.redefinirSenha(novaSenha,confirmaNovaSenha,email,hash);
		
		redirectAttributes.addFlashAttribute("mensagem", mensagem);
		
		return "redirect:/redefinir-senha/"+hash;
	}

}
