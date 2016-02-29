package br.com.semear.gestao.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.semear.gestao.dao.config.ConfigDAO;
import br.com.semear.gestao.service.config.ConfigService;

@Configuration
@EnableWebSecurity
@Import({ConfigDAO.class, ConfigService.class})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource datasource;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.jdbcAuthentication()
		.dataSource(datasource)
		.passwordEncoder(passwordEncoder)
		.usersByUsernameQuery("select usuario, senha, realiza_login as enabled from usuario where usuario = ? ")
		.authoritiesByUsernameQuery("select u.id as usuario,p.id as authority from perfil p, usuario u where" +
				" u.perfil = p.id and u.usuario = ?")
		.getUserDetailsService();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	    .antMatchers("/painel/**").authenticated()
	    .antMatchers("/").access("permitAll")
	    .antMatchers("/403/").access("permitAll")
	    .and().formLogin().usernameParameter("username").passwordParameter("senha")
	    .loginPage("/").loginProcessingUrl("/autenticar")
	    .failureUrl("/")
	    .defaultSuccessUrl("/painel/")
	    .and().logout().deleteCookies("remove")
        .invalidateHttpSession(false)
        .logoutUrl("/logout/").logoutSuccessUrl("/")
		//habilitar depois, estudar os problemas com chamadas AJAX
        .and().csrf().disable()
        .exceptionHandling().accessDeniedPage("/403/");
	    //controla o numero de sesssoes por usuario, neste caso 1 sessao ativa por usuario.
	    http.sessionManagement().maximumSessions(1).expiredUrl("/logout/");
	}
}