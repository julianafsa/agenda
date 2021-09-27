package br.com.santander.agenda.config.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.santander.agenda.model.User;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {
	
//	@SuppressWarnings("deprecation")
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.apiInfo(apiInfo())
			.select()
			.apis(RequestHandlerSelectors.basePackage("br.com.santander.agenda"))
			.paths(PathSelectors.ant("/**"))
			.build()
	        .ignoredParameterTypes(User.class);
//	        .globalOperationParameters(
//        		Arrays.asList(new ParameterBuilder()
//	                .name("Authorization")
//	                .description("Header para Token JWT")
//	                .modelRef(new ModelRef("string"))
//	                .parameterType("header")
//	                .required(false)
//	                .build()));
		
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo("Agenda de Contato", "1.0", 
			null, null, null, null, null, Collections.emptyList());
	}

}