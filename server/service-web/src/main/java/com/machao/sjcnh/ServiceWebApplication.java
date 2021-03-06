package com.machao.sjcnh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@SpringBootApplication 
public class ServiceWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceWebApplication.class, args);
	}
}


