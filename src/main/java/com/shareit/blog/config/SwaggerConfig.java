package com.shareit.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;


@Configuration
public class SwaggerConfig {
	
	
	@Bean
	public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(getInfo())
                // Add JWT Security Configuration
                .addSecurityItem(new SecurityRequirement().addList("BearerAuth"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("BearerAuth", new SecurityScheme()
                                .name("BearerAuth")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
	}

	private Info getInfo() {
		// TODO Auto-generated method stub
		return new Info()
                .title("Blogging Application Backend")
                .description("This project is developed by Ajay Jadhav")
                .version("1.0")
                .contact(new Contact()
                        .name("Ajay")
                        .url("https://ajaytest.com")
                        .email("ajadhav1760@gmail.com"));
	}
}
