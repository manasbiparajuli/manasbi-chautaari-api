package com.manasbi.yml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource(value = "classpath:application.yml", factory = YmlPropertySourceFactory.class)
@Configuration
@ConfigurationProperties(prefix = "swagger-api-info")
@EnableConfigurationProperties
@AllArgsConstructor
@NoArgsConstructor
public class SwaggerApiInfoProperties {

  @NonNull private String title;
  @NonNull private String description;
  @NonNull private String version;
  @NonNull private String contactName;
  @NonNull private String contactUrl;
}
