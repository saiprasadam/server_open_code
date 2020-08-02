package com.openshift.coursecatalogue.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

@Service
public class MailServices {

	@Autowired(required = true)
	JavaMailSender javaMailSender;

	public MailServices(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendMail(JsonNode userNode) {
		try {
			System.out.println("Email is ready");
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(userNode.get("to").asText());
			mailMessage.setSubject(userNode.get("subject").asText());
			mailMessage.setText(userNode.get("message").asText());
			mailMessage.setFrom("indiaperficient@gmail.com");
			javaMailSender.send(mailMessage);
			System.out.println("Mail sent successfully");
		} catch (MailAuthenticationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
