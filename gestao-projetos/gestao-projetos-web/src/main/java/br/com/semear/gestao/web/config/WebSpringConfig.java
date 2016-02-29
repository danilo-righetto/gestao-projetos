package br.com.semear.gestao.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;

import br.com.semear.gestao.web.interceptor.AutorizadorInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(value = { "br.com.semear.gestao" })
public class WebSpringConfig extends WebMvcConfigurerAdapter {

	@Override
	// Carrega as configura��es default do Spring
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	// Resolve as requisi��es de chamadas de p�ginas jsp, xhtml, html...
	// Utilizando tiles
	public ViewResolver configureViewResolver(){
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(org.springframework.web.servlet.view.tiles2.TilesView.class);
		return viewResolver;
	}

	@Bean
	// Inicializa a configura��o do tiles para a cria��o de templates
	public TilesConfigurer tilesConfigurer(){
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("/tiles/tiles-config.xml");
		return tilesConfigurer;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(new AutorizadorInterceptor()).addPathPatterns("/painel/**").excludePathPatterns("/");
	}
}