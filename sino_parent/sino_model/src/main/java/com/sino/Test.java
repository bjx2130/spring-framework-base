package com.sino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class Test {

	
	@Autowired
	private RestTemplate restTemplate;
	
	@ResponseBody
	@RequestMapping(value="test",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String g() {
		
		String url = "http://localhost:9090/getProduct/928137";
		String prodJson =  restTemplate.getForObject(url, String.class);
		System.out.println(prodJson);
		
		return prodJson;
	}
}
