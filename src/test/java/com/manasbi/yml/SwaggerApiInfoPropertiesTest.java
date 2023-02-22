package com.manasbi.yml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles({"dev"})
@ExtendWith(SpringExtension.class)
class SwaggerApiInfoPropertiesTest {
  @Autowired private SwaggerApiInfoProperties swaggerApiInfoProperties;

  @Test
  void testCanEqual() {
    assertFalse(swaggerApiInfoProperties.canEqual("Other"));
    assertTrue(swaggerApiInfoProperties.canEqual(swaggerApiInfoProperties));
  }

  @Test
  void testConstructor() {
    SwaggerApiInfoProperties actualSwaggerApiInfoProperties =
        new SwaggerApiInfoProperties(
            "Dr",
            "The characteristics of someone or something",
            "1.0.2",
            "Contact Name",
            "https://example.org/example");
    String actualToStringResult = actualSwaggerApiInfoProperties.toString();
    assertEquals("Contact Name", actualSwaggerApiInfoProperties.getContactName());
    assertEquals("https://example.org/example", actualSwaggerApiInfoProperties.getContactUrl());
    assertEquals(
        "The characteristics of someone or something",
        actualSwaggerApiInfoProperties.getDescription());
    assertEquals("Dr", actualSwaggerApiInfoProperties.getTitle());
    assertEquals("1.0.2", actualSwaggerApiInfoProperties.getVersion());
    assertEquals(
        "SwaggerApiInfoProperties(title=Dr, description=The characteristics of someone or something, version=1.0.2,"
            + " contactName=Contact Name, contactUrl=https://example.org/example)",
        actualToStringResult);
  }

  @Test
  void testEquals() {
    assertNotEquals(
        new SwaggerApiInfoProperties(
            "Dr",
            "The characteristics of someone or something",
            "1.0.2",
            "Contact Name",
            "https://example.org/example"),
        null);
    assertNotEquals(
        "Different type to SwaggerApiInfoProperties",
        new SwaggerApiInfoProperties(
            "Dr",
            "The characteristics of someone or something",
            "1.0.2",
            "Contact Name",
            "https://example.org/example"));
  }

  @Test
  void testEquals2() {
    SwaggerApiInfoProperties swaggerApiInfoProperties =
        new SwaggerApiInfoProperties(
            "Dr",
            "The characteristics of someone or something",
            "1.0.2",
            "Contact Name",
            "https://example.org/example");
    assertEquals(swaggerApiInfoProperties, swaggerApiInfoProperties);
    int expectedHashCodeResult = swaggerApiInfoProperties.hashCode();
    assertEquals(expectedHashCodeResult, swaggerApiInfoProperties.hashCode());
  }

  @Test
  void testEquals3() {
    SwaggerApiInfoProperties swaggerApiInfoProperties =
        new SwaggerApiInfoProperties(
            "Dr",
            "The characteristics of someone or something",
            "1.0.2",
            "Contact Name",
            "https://example.org/example");
    SwaggerApiInfoProperties swaggerApiInfoProperties1 =
        new SwaggerApiInfoProperties(
            "Dr",
            "The characteristics of someone or something",
            "1.0.2",
            "Contact Name",
            "https://example.org/example");

    assertEquals(swaggerApiInfoProperties, swaggerApiInfoProperties1);
    int expectedHashCodeResult = swaggerApiInfoProperties.hashCode();
    assertEquals(expectedHashCodeResult, swaggerApiInfoProperties1.hashCode());
  }

  @Test
  void testEquals4() {
    SwaggerApiInfoProperties swaggerApiInfoProperties =
        new SwaggerApiInfoProperties(
            "Mr",
            "The characteristics of someone or something",
            "1.0.2",
            "Contact Name",
            "https://example.org/example");
    assertNotEquals(
        swaggerApiInfoProperties,
        new SwaggerApiInfoProperties(
            "Dr",
            "The characteristics of someone or something",
            "1.0.2",
            "Contact Name",
            "https://example.org/example"));
  }

  @Test
  void testEquals5() {
    SwaggerApiInfoProperties swaggerApiInfoProperties =
        new SwaggerApiInfoProperties(
            "Dr", "Dr", "1.0.2", "Contact Name", "https://example.org/example");
    assertNotEquals(
        swaggerApiInfoProperties,
        new SwaggerApiInfoProperties(
            "Dr",
            "The characteristics of someone or something",
            "1.0.2",
            "Contact Name",
            "https://example.org/example"));
  }

  @Test
  void testEquals6() {
    SwaggerApiInfoProperties swaggerApiInfoProperties =
        new SwaggerApiInfoProperties(
            "Dr",
            "The characteristics of someone or something",
            "Dr",
            "Contact Name",
            "https://example.org/example");
    assertNotEquals(
        swaggerApiInfoProperties,
        new SwaggerApiInfoProperties(
            "Dr",
            "The characteristics of someone or something",
            "1.0.2",
            "Contact Name",
            "https://example.org/example"));
  }

  @Test
  void testEquals7() {
    SwaggerApiInfoProperties swaggerApiInfoProperties =
        new SwaggerApiInfoProperties(
            "Dr",
            "The characteristics of someone or something",
            "1.0.2",
            "Dr",
            "https://example.org/example");
    assertNotEquals(
        swaggerApiInfoProperties,
        new SwaggerApiInfoProperties(
            "Dr",
            "The characteristics of someone or something",
            "1.0.2",
            "Contact Name",
            "https://example.org/example"));
  }

  @Test
  void testEquals8() {
    SwaggerApiInfoProperties swaggerApiInfoProperties =
        new SwaggerApiInfoProperties(
            "Dr", "The characteristics of someone or something", "1.0.2", "Contact Name", "Dr");
    assertNotEquals(
        swaggerApiInfoProperties,
        new SwaggerApiInfoProperties(
            "Dr",
            "The characteristics of someone or something",
            "1.0.2",
            "Contact Name",
            "https://example.org/example"));
  }

  @Test
  void testEquals9() {
    SwaggerApiInfoProperties swaggerApiInfoProperties = new SwaggerApiInfoProperties();
    assertNotEquals(
        swaggerApiInfoProperties,
        new SwaggerApiInfoProperties(
            "Dr",
            "The characteristics of someone or something",
            "1.0.2",
            "Contact Name",
            "https://example.org/example"));
  }

  @Test
  void testSetContactName() {
    SwaggerApiInfoProperties swaggerApiInfoProperties =
        new SwaggerApiInfoProperties(
            "Dr",
            "The characteristics of someone or something",
            "1.0.2",
            "Contact Name",
            "https://example.org/example");
    swaggerApiInfoProperties.setContactName("Contact Name");
    assertEquals("Contact Name", swaggerApiInfoProperties.getContactName());
  }

  @Test
  void testSetContactUrl() {
    SwaggerApiInfoProperties swaggerApiInfoProperties =
        new SwaggerApiInfoProperties(
            "Dr",
            "The characteristics of someone or something",
            "1.0.2",
            "Contact Name",
            "https://example.org/example");
    swaggerApiInfoProperties.setContactUrl("https://example.org/example");
    assertEquals("https://example.org/example", swaggerApiInfoProperties.getContactUrl());
  }

  @Test
  void testSetDescription() {
    SwaggerApiInfoProperties swaggerApiInfoProperties =
        new SwaggerApiInfoProperties(
            "Dr",
            "The characteristics of someone or something",
            "1.0.2",
            "Contact Name",
            "https://example.org/example");
    swaggerApiInfoProperties.setDescription("The characteristics of someone or something");
    assertEquals(
        "The characteristics of someone or something", swaggerApiInfoProperties.getDescription());
  }

  @Test
  void testSetTitle() {
    SwaggerApiInfoProperties swaggerApiInfoProperties =
        new SwaggerApiInfoProperties(
            "Dr",
            "The characteristics of someone or something",
            "1.0.2",
            "Contact Name",
            "https://example.org/example");
    swaggerApiInfoProperties.setTitle("Dr");
    assertEquals("Dr", swaggerApiInfoProperties.getTitle());
  }

  @Test
  void testSetVersion() {
    SwaggerApiInfoProperties swaggerApiInfoProperties =
        new SwaggerApiInfoProperties(
            "Dr",
            "The characteristics of someone or something",
            "1.0.2",
            "Contact Name",
            "https://example.org/example");
    swaggerApiInfoProperties.setVersion("1.0.2");
    assertEquals("1.0.2", swaggerApiInfoProperties.getVersion());
  }
}
