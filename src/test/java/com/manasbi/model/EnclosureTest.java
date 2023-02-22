package com.manasbi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnclosureTest {
  @Test
  void testConstructor() {
    Enclosure actualEnclosure = new Enclosure("https://example.org/example", 3L, "Media Type");

    assertEquals(3L, actualEnclosure.episodeLength());
    assertEquals("https://example.org/example", actualEnclosure.url());
    assertEquals("Media Type", actualEnclosure.mediaType());
  }

  @Test
  void testEpisodeLength() {
    assertEquals(
        3L, (new Enclosure("https://example.org/example", 3L, "Media Type")).episodeLength());
  }

  @Test
  void testMediaType() {
    assertEquals(
        "Media Type", (new Enclosure("https://example.org/example", 3L, "Media Type")).mediaType());
  }

  @Test
  void testUrl() {
    assertEquals(
        "https://example.org/example",
        (new Enclosure("https://example.org/example", 3L, "Media Type")).url());
  }
}
