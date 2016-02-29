package br.com.semear.gestao.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@EnableAsync
//@EnableScheduling
//@PropertySources(
//		{
//			@PropertySource("classpath:/br/com/beenthere/mail/mail-config.properties"),
//		})
@EnableTransactionManagement
public class ConfigService {
	
//	@Autowired
//	private Environment env;
	
	@Bean
	PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
//	@Bean
//	JavaMailSenderImpl javaMail() {
//		JavaMailSenderImpl mail = new JavaMailSenderImpl();
//		mail.setUsername(env.getProperty("br.com.beenthere.mail.username"));
//		mail.setPassword(env.getProperty("br.com.beenthere.mail.password"));
//		Properties properties = new Properties();
//		properties.setProperty("mail.transport.protocol", env.getProperty("br.com.beenthere.mail.protocol"));
//		properties.setProperty("mail.smtp.auth", env.getProperty("br.com.beenthere.mail.auth"));
//		properties.setProperty("mail.smtp.starttls.enable", env.getProperty("br.com.beenthere.mail.starttls"));
//		properties.setProperty("mail.smtp.debug", env.getProperty("br.com.beenthere.mail.debug"));
//		properties.setProperty("mail.smtp.host", env.getProperty("br.com.beenthere.mail.host"));
//		properties.setProperty("mail.smtp.port", env.getProperty("br.com.beenthere.mail.port"));
//		properties.setProperty("mail.smtp.ssl.trust", env.getProperty("br.com.beenthere.mail.ssl"));
//		mail.setJavaMailProperties(properties);
//		return mail;
//	}
//		
//	@Bean
//	public VelocityEngine velocityEngine() throws VelocityException, IOException {
//		VelocityEngineFactoryBean velocityFactory = new VelocityEngineFactoryBean();
//		velocityFactory.setResourceLoaderPath("/br/com/beenthere/mail/");
//		return velocityFactory.createVelocityEngine();
//	}

}
