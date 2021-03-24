package com.kh.toy.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class AppConfig {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public JavaMailSender javaMailSender() {
		
		Properties mailProperties = new Properties();
		mailProperties.setProperty("mail.transport.protocol", "smtp");
		mailProperties.setProperty("mail.smtp.auth", "true");
		mailProperties.setProperty("mail.smtp.starttls.enable", "true");
		mailProperties.setProperty("mail.smtp.ssl.enable", "true");
		mailProperties.setProperty("mail.debug", "true");
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setUsername("killsky2014@naver.com");
		mailSender.setPassword("1256812gk!A!");
		mailSender.setPort(465);
		mailSender.setHost("smtp.naver.com");
		mailSender.setJavaMailProperties(mailProperties);
		
		return mailSender;
	}
	
	@Bean
	public RestTemplate restTemplate() {
		SimpleClientHttpRequestFactory requestFactory =
				new SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(5000);
		requestFactory.setReadTimeout(5000);

		return new RestTemplate(requestFactory);
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxInMemorySize(10485760);
		multipartResolver.setMaxUploadSize(10485760);
		return multipartResolver;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
