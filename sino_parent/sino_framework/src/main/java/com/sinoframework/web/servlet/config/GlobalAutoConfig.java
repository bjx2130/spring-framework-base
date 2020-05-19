package com.sinoframework.web.servlet.config;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sinoframework.web.servlet.advice.ResponseControllerAdvice;
import com.sinoframework.web.servlet.advice.SinoGlobalExceptionHandler;

@Configuration
@ImportAutoConfiguration({
			ResponseControllerAdvice.class,
			SinoGlobalExceptionHandler.class
		})
@ComponentScan(basePackages = "com.sinoframework.web.servlet.util")
public class GlobalAutoConfig {
	
	
	
}
