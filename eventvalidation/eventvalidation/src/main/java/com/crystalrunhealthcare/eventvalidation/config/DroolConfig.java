package com.crystalrunhealthcare.eventvalidation.config;

import java.io.IOException;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

/**
 * 
 * @author Medevantage
 *
 */
@Configuration
@EnableSwagger2
public class DroolConfig {

	private static final String G = "com.crystalrunhealthcare";
	private static final String A = "eventrules";
	private static final String V = "0.0.1-SNAPSHOT";
	
	private KieServices kieServices = KieServices.Factory.get();
	
/**
 * Here the container is created
 * @return container
 */
	@Bean
	public KieContainer getKieContainer() {
		try {
			System.out.println("Container created...");
			ReleaseId releaseID = kieServices.newReleaseId(G, A, V);
			KieContainer kContainer = kieServices.newKieContainer(releaseID);

			KieScanner kScanner = kieServices.newKieScanner(kContainer);
			kScanner.start(5000);
			return kContainer;
			
		} catch (Exception e) {
			System.out.println("In error");
		}
		return null;

	}
/**
 * sessions is created here
 * @return session
 * @throws IOException
 */
	@Bean
	public KieSession getKieSession() throws IOException {
		System.out.println("session created...");
		KieBase kBase = getKieContainer().getKieBase("EventRulesKB");
		KieSession kSession = kBase.newKieSession();
		return kSession;
	}
	
	/*@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return (Predicate<String>) or(regex("/api/posts.*"), regex("/validateEvent.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.description("Swagger documentation")
				.build();
	}

	*/
	
	@Bean
    public Docket api() {
        // @formatter:off
        //Register the controllers to swagger
        //Also it is configuring the Swagger Docket
        return new Docket(DocumentationType.SWAGGER_2).select()
                // .apis(RequestHandlerSelectors.any())
                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                // .paths(PathSelectors.any())
                // .paths(PathSelectors.ant("/swagger2-demo"))
                .build();
        // @formatter:on
    }
 
	public void addResourceHandlers(ResourceHandlerRegistry registry) 
    {
        //enabling swagger-ui part for visual documentation
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}



