package com.sino;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

class JTest {

	@Test
	void test() throws Exception {
		
//		# Autoconfig
//		org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
//		org.springframework.cloud.security.oauth2.gateway.TokenRelayAutoConfiguration,\
//		org.springframework.cloud.security.oauth2.proxy.OAuth2ProxyAutoConfiguration,\
//		org.springframework.cloud.security.oauth2.client.OAuth2LoadBalancerClientAutoConfiguration,\
//		org.springframework.cloud.security.oauth2.client.ResourceServerTokenRelayAutoConfiguration
		 	String reqURL = String.format("http://localhost:9091/list");
	        RestTemplate restTemplate = new RestTemplate();
	        
	        try {
	        	HttpHeaders requestHeaders = new HttpHeaders();
		        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		        HttpEntity<String> requestEntity = new HttpEntity<String>(requestHeaders);
	            ResponseEntity<Boolean> resp = restTemplate.exchange(reqURL,HttpMethod.POST,requestEntity,Boolean.class);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
