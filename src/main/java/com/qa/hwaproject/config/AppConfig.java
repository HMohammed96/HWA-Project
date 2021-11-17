package com.qa.hwaproject.config;

import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public String greeting() {
		return "Hello, world";
	}
	
	@Bean
	public LocalTime currentTime() {
		return LocalTime.now();
	}

}
