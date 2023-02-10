package com.manasbi.swagger;

import com.manasbi.yml.SwaggerApiInfoProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@RequiredArgsConstructor
public class SpringFoxConfiguration {

  private final SwaggerApiInfoProperties swaggerApiInfoProperties;

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.manasbi.controller"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(metadata());
  }

  private ApiInfo metadata() {
    return new ApiInfoBuilder()
        .title(swaggerApiInfoProperties.getTitle())
        .description(swaggerApiInfoProperties.getDescription())
        .version(swaggerApiInfoProperties.getVersion())
        .contact(
            new Contact(
                swaggerApiInfoProperties.getContactName(),
                swaggerApiInfoProperties.getContactUrl(),
                null))
        .build();
  }
}
