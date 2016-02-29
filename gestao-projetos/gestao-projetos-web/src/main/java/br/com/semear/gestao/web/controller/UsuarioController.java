package br.com.semear.gestao.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.PerfilService;
import br.com.semear.gestao.service.UsuarioService;

@Controller
@RequestMapping("/painel/usuarios")
public class UsuarioController {
	
	private ModelAndView mav = new ModelAndView();
	
	@Inject
	private UsuarioService usuarioService;
	
	@Inject
	private PerfilService perfilService;
	
	@RequestMapping("/")
	public ModelAndView listaDeUsuarios(){
		mav.clear();
		mav.setViewName("listar-usuarios");
		mav.addObject("usuarios", usuarioService.listarUsuarios());
		return mav;
	}
	
	/**REALIZA O ACESSO A PAGINA DE CADASTRO DE USUARIO
	 * @return
	 */
	@RequestMapping("cadastro")
	public ModelAndView formCadastro(){
		mav.clear();
		mav.setViewName("cadastroUsuario");
		mav.addObject("listaperfil", perfilService.listarPerfil());
		return mav;
	}
	
	/** REALIZA O CADASTRO DO USUARIO NO SISTEMA.
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value="salvarUsuario", method=RequestMethod.POST)
	public String salvarUsuario(Usuario usuario){
		usuarioService.cadastrarUsuario(usuario);
		return "redirect:/painel/usuarios/";
	}
	
	/**REALIZA A CONSULTA SE O USUARIO EXISTE NO BANCO DE DADOS
	 * @param login
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="consultarUsuario", method=RequestMethod.POST)
	public boolean consultarUsuario(String login){
		boolean usuarioExiste = false;
		
		if(usuarioService.buscarUsuarioPorLogin(login) != null){
			usuarioExiste = true;
		}
		
		return usuarioExiste;
		
	}
	
	/**REALIZA O ACESSO A PAGINA DE EDICAO DE USUARIO
	 * @param idUsuario
	 * @return
	 */
	@RequestMapping(value="editar/{idUsuario}")
	public ModelAndView formEditar(@PathVariable("idUsuario") long idUsuario){
		mav.clear();
		mav.setViewName("editarUsuario");
		mav.addObject("listaperfil", perfilService.listarPerfil());
		mav.addObject("user", usuarioService.buscarUsuarioPorId(idUsuario));
		return mav;
	}
	
	/** REALIZA A EDICAO DO USUARIO NO SISTEMA
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value="editarUsuario", method=RequestMethod.POST)
	public String editarUsuario(Usuario usuario){
		usuarioService.editarUsuario(usuario);
		return "redirect:/painel/usuarios/";
	}
	
}
