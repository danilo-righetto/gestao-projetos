package br.com.semear.gestao.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.velocity.VelocityEngineUtils;

import br.com.semear.gestao.service.MailService;

@PropertySources({ @PropertySource("classpath:/application.properties") })

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MailServiceImpl implements MailService {

	@Autowired(required = false)
	private JavaMailSenderImpl mail;

	@Autowired
	private VelocityEngine velocityEngine;

	@Value("${email-remetente}")
	private String remetente;

	@Value("${email-adm}")
	private String emailAdm;

	@Value("${url}")
	private String link;

	private String templateEmailEsqueceuSenha = "esqueceu-senha.vm";

	private String templateEmailNovaSenha = "nova-senha.vm";

	@Override
	public void enviarEmailNovaSenha(final String email, final String hash) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);

				message.setTo(email);
				message.setSubject("[Sistema - Gestão de Projetos] - Solicitação de senha");
				message.setFrom(remetente);

				Map<String, Object> objects = new HashMap<String, Object>();
				objects.put("url", link + "redefinir-senha/" + hash);

				final String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						templateEmailEsqueceuSenha, "ISO-8859-1", objects);
				message.setText(text, true);
			}
		};
		mail.send(preparator);
	}

	@Override
	public void enviarEmailSenhaCriada(final String email, final String senha) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);

				message.setTo(email);
				message.setSubject("[Sistema - Gestão de Projetos] - Acesso ao Sistema");
				message.setFrom(remetente);

				Map<String, Object> objects = new HashMap<String, Object>();
				objects.put("usuario", email);
				objects.put("senha", senha);

				final String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateEmailNovaSenha,
						"ISO-8859-1", objects);
				message.setText(text, true);
			}
		};
		mail.send(preparator);
	}

}
