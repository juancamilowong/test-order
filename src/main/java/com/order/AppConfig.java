package com.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	@Bean("orderRest")
	public RestTemplate registerRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
}
