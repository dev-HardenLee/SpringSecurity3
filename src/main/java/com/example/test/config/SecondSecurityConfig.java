package com.example.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.extern.log4j.Log4j2;

@Configuration
@EnableWebSecurity(debug = true)
@Order(1)
@Log4j2
public class SecondSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().mvcMatchers("/favicon.ico");
		web.ignoring().mvcMatchers("/error");
	}// configure

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("{noop}1111").authorities("USER");
	}// configure

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() // 딱히 설정을 안하면 AnyRequestMatcher가 생성된다.
			.antMatchers("/user").hasRole("USER")
			.anyRequest().permitAll();
		
		http.formLogin();
	}// configure
	
	
	
}// SecondSecurityConfig
