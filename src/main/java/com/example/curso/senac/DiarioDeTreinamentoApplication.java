package com.example.curso.senac;

import java.util.Arrays;
import java.util.Collections;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.curso.senac.repository.SessaoDao;
import com.example.curso.senac.repository.SessaoRepository;
import com.example.curso.senac.web.controller.HomeController;

@Configuration
@ComponentScan(basePackageClasses={HomeController.class, SessaoRepository.class, SessaoDao.class})
@EnableJpaRepositories("com.example.curso.senac.repository")
@EntityScan("com.example.curso.senac.model")
@SpringBootApplication
public class DiarioDeTreinamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiarioDeTreinamentoApplication.class, args);
			
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**").allowedOrigins("http://localhost:3000");
	        }
	    };
	}

}
