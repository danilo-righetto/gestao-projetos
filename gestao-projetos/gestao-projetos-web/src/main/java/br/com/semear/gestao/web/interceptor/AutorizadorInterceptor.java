package br.com.semear.gestao.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter{
	@Override
	  public boolean preHandle(HttpServletRequest request,
	      HttpServletResponse response,
	      Object controller) throws Exception {
	      if(request.getRequestURI().equals("/gestao-projetos/painel") || request.getRequestURI().equals("/gestao-projetos/painel/")
	    		  || request.getSession().getAttribute("usuario") != null) {
	        return true;
	      }
	      else if(request.getRequestURI().equals("/gestao-projetos/logout")){
	    	  request.getSession().invalidate();
	      }
	      	response.sendRedirect("/gestao-projetos/painel");
	      return false;
	  }

}
