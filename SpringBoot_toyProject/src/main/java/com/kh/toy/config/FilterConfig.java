package com.kh.toy.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.MultipartFilter;

@Configuration
public class FilterConfig {
	
   @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        // csrf + multipart
        tomcat.addContextCustomizers(context -> context.setAllowCasualMultipartParsing(true));
        return tomcat;
    }
	
	@Bean
	public FilterRegistrationBean multipartFilter(){
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.addUrlPatterns("/*"); 
		registrationBean.setFilter(new MultipartFilter());
		registrationBean.setOrder(1);
		return registrationBean;
	}

}
