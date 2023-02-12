package com.manasbi.swagger;

import com.manasbi.yml.SwaggerApiInfoProperties;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpringDocConfiguration {

  private final SwaggerApiInfoProperties swaggerApiInfoProperties;

  @Bean
  public GroupedOpenApi publicApi() {
    return GroupedOpenApi.builder()
        .group("manasbi-chautaari-public-apis")
        .pathsToMatch("/api/**")
        .build();
  }

  @Bean
  public OpenAPI metadata() {
    return new OpenAPI()
        .info(
            new Info()
                .title(swaggerApiInfoProperties.getTitle())
                .description(swaggerApiInfoProperties.getDescription())
                .version(swaggerApiInfoProperties.getVersion())
                .contact(
                    new Contact()
                        .name(swaggerApiInfoProperties.getContactName())
                        .url(swaggerApiInfoProperties.getContactUrl())));
  }
}
