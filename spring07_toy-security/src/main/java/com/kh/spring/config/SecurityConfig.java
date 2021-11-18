package com.kh.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity //Spring Security의 기본설정 대신 선언된 클래스에서 설정한 내용을 시큐리티에 적용
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private UserDetailsService memberServiceImpl;
	
	@Configuration
	public class AppConfig {
	    @Bean(name = "mvcHandlerMappingIntrospector")
	    public HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
	        return new HandlerMappingIntrospector();
	    }
	}
	
	public PersistentTokenRepository tokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		return tokenRepository;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.mvcMatchers("/static/**");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.mvcMatchers(HttpMethod.GET,"/member/mypage", "/member/logout").authenticated()
			.anyRequest().permitAll();
			
		http.formLogin()
			.loginProcessingUrl("/member/login")
			.usernameParameter("userId")
			.loginPage("/member/login")
			.defaultSuccessUrl("/");
		
		http.logout()
		.logoutUrl("/member/logout")
		.logoutSuccessUrl("/member/login");
		
		http.rememberMe()
		.userDetailsService(memberServiceImpl)
		.tokenRepository(tokenRepository());
		
		http.csrf().ignoringAntMatchers("/mail");
	}
	
	

}
