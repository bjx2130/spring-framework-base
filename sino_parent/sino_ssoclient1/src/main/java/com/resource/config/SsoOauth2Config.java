package com.resource.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 单点登录
 * 1、启用@EnableOAuth2Sso
 * 2、application.yml中配置
 * 		# 认证服务器地址
		auth-server: http://localhost:8888
		# 客户端
		security:
		  oauth2:
		    client:
		      client-id: sso #用户名错误报错【error="invalid_client", error_description="Bad client credentials"】
		      client-secret: secret #密码错误【There was an unexpected error (type=Unauthorized, status=401).】或【There was an unexpected error (type=Internal Server Error, status=500).】
		      scope: all
		      access-token-uri: ${auth-server}/oauth/token
		      user-authorization-uri: ${auth-server}/oauth/authorize
		    resource:
		      token-info-uri: ${auth-server}/oauth/check_token
 * 
 * 
 * @author Administrator
 *
 */
@Configuration
@EnableOAuth2Sso
public class SsoOauth2Config  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页和登录页允许，其他请求均要鉴权
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login", "/error", "/loginOut").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout()
//                .logoutSuccessHandler(
//                        ((request, response, authentication) -> {
//                            response.sendRedirect(oauthHost.split("oauth")[0] + "logout?callback=http://" + request.getHeader("Host"));
//                        })
//                )
                .logoutSuccessUrl("http://localhost:8888/auth/oauth/exit")
                .and().cors().and().csrf().disable();
        		
    }
}
