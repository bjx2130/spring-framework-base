package com.example.oauth.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

@Configuration
public class SpringSecutityBeanConfiguration {
	
	
	
	/**
	 * 在spring5.0之后，springsecurity client密码 和 user密码必须用 PasswordEncoder 加密
	 * @return
	 */
    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder(){
    	return new BCryptPasswordEncoder();
    }
    
    
    
    /**
     * 自定义 用户表和权限表 就需要自己实现一下三个接口：
     * 		UserDetailsService 参考:org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl
     * 		UserDetails 参考：org.springframework.security.core.userdetails.User
     *      GrantedAuthority 参考:org.springframework.security.core.authority.SimpleGrantedAuthority
     *      
     * 以下使用springsecurity定义的用户信息表
     * 
     * @param dataSource
     * @return
     */
    @Bean
    UserDetailsService userDetails(@Autowired DataSource dataSource){
    	JdbcDaoImpl dao = new JdbcDaoImpl();
    	dao.setDataSource(dataSource);
        return dao;
    }
	
    

    /**
     * 自定义客户端表实现以下接口：
     * 		ClientDetailsService 参考：org.springframework.security.oauth2.provider.client.JdbcClientDetailsService
     * 
     * 
     * 以下使用springsecurity定义的客户端表
     * 
     * @param dataSource
     * @return
     */
    @Bean(value = "customClientDetailsService")
    ClientDetailsService customClientDetailsService(@Autowired DataSource dataSource) { 
    	return new JdbcClientDetailsService(dataSource);
    }
    
	
}
