package com.example.oauth.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.oauth.authentication.handler.CustomSavedRequestAwareAuthenticationSuccessHandler;

@AutoConfigureAfter(value = SpringSecutityBeanConfiguration.class)
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	private UserDetailsService userDetailsService;

	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
//                .antMatchers("/", "/home").permitAll()//不需要认证就可以访问
                .antMatchers("/**").hasAnyRole("USER")//需要身份验证
                .and().csrf().disable()
            .formLogin().successHandler(customSavedRequestAwareAuthenticationSuccessHandler());
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// https://docs.spring.io/spring-security/site/docs/5.0.7.BUILD-SNAPSHOT/reference/htmlsingle/
//==========使用内存存储用户名信息=============
//		auth.inMemoryAuthentication().passwordEncoder(bcryptPasswordEncoder).withUser("admin")
//				.password(bcryptPasswordEncoder.encode("111")).roles("USER").and().withUser("admin2")
//				.password(bcryptPasswordEncoder.encode("222")).roles("ADMIN");
  
    	
//==========使用数据库存储用户名信息=============   	
    	auth.userDetailsService(userDetailsService).passwordEncoder(bcryptPasswordEncoder);
    	
    }
    
    
    
	public CustomSavedRequestAwareAuthenticationSuccessHandler customSavedRequestAwareAuthenticationSuccessHandler() {
		return new CustomSavedRequestAwareAuthenticationSuccessHandler();
	}
    
    
}
