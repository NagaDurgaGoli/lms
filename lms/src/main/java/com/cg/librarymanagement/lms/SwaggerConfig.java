package com.cg.librarymanagement.lms;

/** 
 AUTHOR : Prathyusha Narsupalli
 */

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.ant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
				.paths(pathsToBeDocumented()).build();
	}
     private Predicate<String> pathsToBeDocumented() {
		return or(ant("/user/**"),ant("/useraddress/**"),
				ant("/books/**"),ant("/booksorder/**"),
				ant("/booksissued/**"),ant("/booksreturned/**"),
	            ant("/author/**"),
	            ant("/publishers/**"),ant("/feedback/**"),ant("/booksissued/**"),ant("/booksreturned/**")
	           );
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("LMS API").description("Library Management System API").license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0").build();
	}

}

