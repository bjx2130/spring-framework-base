package com.sinoframework.web.servlet.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import com.sinoframework.web.servlet.interceptor.resttemplate.MixLoadBalancerInterceptor;

@Configuration
public class RestTemplateAutoConfig {
	private static final Logger log = LoggerFactory.getLogger(RestTemplateAutoConfig.class);
	
	
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		log.info("启用【RestTemplate 实例】");
		return new RestTemplate();
	}
	
	
	/**
	 * @LoadBalanced 支持ip、域名、服务名 调用
	 * 	其它配置参考类 MixLoadBalancerInterceptor
	 * 
	 * @param restTemplates
	 * @param restTemplateBuilder
	 * @return
	 */
    @Bean
    @ConditionalOnProperty(prefix="mix.loadbalancer",name = "enable", matchIfMissing = true)
    public SmartInitializingSingleton mixLoadBalancedRestTemplateInitializer(
            @Autowired List<RestTemplate> restTemplates,
            @Autowired RestTemplateBuilder restTemplateBuilder) {
    	
    	log.info("启用【RestTemplate 支持ip、域名、服务名 调用】");
    	
    	MixLoadBalancerInterceptor mixLoadBalancerInterceptor= new MixLoadBalancerInterceptor(restTemplateBuilder.buildRequestFactory());
        return () -> {
            for (RestTemplate restTemplate : restTemplates) {
                List<ClientHttpRequestInterceptor> list = new ArrayList<>(restTemplate.getInterceptors());
                list.add(mixLoadBalancerInterceptor);
                restTemplate.setInterceptors(list);
            }
        };
    }
    
	
	
}
