package com.sinoframework.web.servlet.config;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import com.sinoframework.web.servlet.advice.ResponseControllerAdvice;
import com.sinoframework.web.servlet.advice.SinoGlobalExceptionHandler;

@Configuration
@ImportAutoConfiguration({
			ResponseControllerAdvice.class,
			SinoGlobalExceptionHandler.class
		})
public class GlobalAutoConfig {
	

}
