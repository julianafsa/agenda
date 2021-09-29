package br.com.santander.agenda.config.swagger;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.security.SecurityScheme.In;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import org.springframework.http.HttpHeaders;

@Configuration
public class SwaggerConfigurations {
	
	@Bean
	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2)
//		.apiInfo(apiInfo())
//		.select()
//		.apis(RequestHandlerSelectors.basePackage("br.com.santander.agenda"))
//		.paths(PathSelectors.ant("/**"))
//		.build()
//        .ignoredParameterTypes(User.class)
//        .globalOperationParameters(
//    		Arrays.asList(new ParameterBuilder()
//                .name("Authorization")
//                .description("Header para Token JWT")
//                .modelRef(new ModelRef("string"))
//                .parameterType("header")
//                .required(false)
//                .build()));		
		return new Docket(DocumentationType.SWAGGER_2)
			      .apiInfo(apiInfo())
//			      .securityContexts(Arrays.asList(securityContext()))
			      .securitySchemes(Arrays.asList(apiKey()))
			      .select()
			      .apis(RequestHandlerSelectors.basePackage("br.com.santander.agenda"))
			      .paths(PathSelectors.any())
			      .build();
		
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo("Agenda de Contato", "1.0", 
			null, null, null, null, null, Collections.emptyList());
	}
	
	private ApiKey apiKey() { 
	    return new ApiKey("JWT", HttpHeaders.AUTHORIZATION, In.HEADER.name()); 
	}
	
	private SecurityContext securityContext() { 
	    return SecurityContext.builder().securityReferences(defaultAuth()).build(); 
	} 
	
	private List<SecurityReference> defaultAuth() { 
	    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything"); 
	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1]; 
	    authorizationScopes[0] = authorizationScope; 
	    return Arrays.asList(new SecurityReference("JWT", authorizationScopes)); 
	}

}