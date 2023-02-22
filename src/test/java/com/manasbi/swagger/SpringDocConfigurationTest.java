package com.manasbi.swagger;

import com.manasbi.yml.SwaggerApiInfoProperties;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.SpecVersion;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springdoc.core.customizers.RouterOperationCustomizer;
import org.springdoc.core.filters.OpenApiMethodFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles({"dev"})
@ExtendWith(SpringExtension.class)
class SpringDocConfigurationTest {
  @Autowired private SpringDocConfiguration springDocConfiguration;

  @Test
  void testPublicApi() {
    GroupedOpenApi actualPublicApiResult =
        (new SpringDocConfiguration(
                new SwaggerApiInfoProperties(
                    "Dr",
                    "The characteristics of someone or something",
                    "1.0.2",
                    "Contact Name",
                    "https://example.org/example")))
            .publicApi();
    assertNull(actualPublicApiResult.getConsumesToMatch());
    List<RouterOperationCustomizer> routerOperationCustomizers =
        actualPublicApiResult.getRouterOperationCustomizers();
    assertTrue(routerOperationCustomizers.isEmpty());
    assertNull(actualPublicApiResult.getProducesToMatch());
    assertEquals(1, actualPublicApiResult.getPathsToMatch().size());
    assertNull(actualPublicApiResult.getPathsToExclude());
    assertNull(actualPublicApiResult.getPackagesToScan());
    assertNull(actualPublicApiResult.getPackagesToExclude());
    List<OperationCustomizer> operationCustomizers =
        actualPublicApiResult.getOperationCustomizers();
    assertEquals(routerOperationCustomizers, operationCustomizers);
    List<OpenApiMethodFilter> openApiMethodFilters =
        actualPublicApiResult.getOpenApiMethodFilters();
    assertEquals(operationCustomizers, openApiMethodFilters);
    assertEquals(openApiMethodFilters, actualPublicApiResult.getOpenApiCustomisers());
    assertNull(actualPublicApiResult.getHeadersToMatch());
    assertEquals("manasbi-chautaari-public-apis", actualPublicApiResult.getGroup());
    assertEquals("manasbi-chautaari-public-apis", actualPublicApiResult.getDisplayName());
  }

  @Test
  void testMetadata() {
    OpenAPI actualMetadataResult = springDocConfiguration.metadata();
    assertNull(actualMetadataResult.getComponents());
    assertNull(actualMetadataResult.getWebhooks());
    assertNull(actualMetadataResult.getTags());
    assertEquals(SpecVersion.V30, actualMetadataResult.getSpecVersion());
    assertNull(actualMetadataResult.getServers());
    assertNull(actualMetadataResult.getSecurity());
    assertNull(actualMetadataResult.getPaths());
    assertEquals("3.0.1", actualMetadataResult.getOpenapi());
    assertNull(actualMetadataResult.getExternalDocs());
    assertNull(actualMetadataResult.getExtensions());
    Info info = actualMetadataResult.getInfo();
    assertEquals("Manasbi Chautaari API", info.getTitle());
    assertNull(info.getTermsOfService());
    assertNull(info.getSummary());
    assertNull(info.getLicense());
    assertNull(info.getExtensions());
    assertEquals("Manasbi Chautaari API Swagger Documentation", info.getDescription());
    assertEquals("0.0.1", info.getVersion());
    Contact contact = info.getContact();
    assertEquals("https://github.com/manasbiparajuli", contact.getUrl());
    assertEquals("Manasbi Parajuli", contact.getName());
    assertNull(contact.getExtensions());
    assertNull(contact.getEmail());
  }
}
