package com.orion.cruxbank.config.swagger;

import org.springframework.context.annotation.Bean;

import com.orion.cruxbank.model.Usuario;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfiguration {
	
	@Bean
	public Docket cruxbankApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.orion.cruxbank"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.ignoredParameterTypes(Usuario.class);
	}

}
