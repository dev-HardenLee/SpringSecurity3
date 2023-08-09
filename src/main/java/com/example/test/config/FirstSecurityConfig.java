package com.example.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.extern.log4j.Log4j2;

@Configuration
@EnableWebSecurity(debug = true)
@Order(0)
@Log4j2
public class FirstSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/admin/**") // 내부적으로 AntPathRequestMatcher가 생성된다.
			.authorizeRequests()
			.anyRequest().authenticated();
		
		http.httpBasic();
	}// configure
	
	
	
}// FirstSecurityConfig
