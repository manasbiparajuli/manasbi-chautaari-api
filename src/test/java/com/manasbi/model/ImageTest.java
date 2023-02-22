package com.manasbi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImageTest {
  @Test
  void testConstructor() {
    Image actualImage = new Image("https://example.org/example", "Dr", "Podcast Word Press Link");

    assertEquals("Dr", actualImage.podcastTitle());
    assertEquals("https://example.org/example", actualImage.url());
    assertEquals("Podcast Word Press Link", actualImage.podcastWordPressLink());
  }

  @Test
  void testPodcastTitle() {
    assertEquals(
        "Dr",
        (new Image("https://example.org/example", "Dr", "Podcast Word Press Link")).podcastTitle());
  }

  @Test
  void testPodcastWordPressLink() {
    assertEquals(
        "Podcast Word Press Link",
        (new Image("https://example.org/example", "Dr", "Podcast Word Press Link"))
            .podcastWordPressLink());
  }

  @Test
  void testUrl() {
    assertEquals(
        "https://example.org/example",
        (new Image("https://example.org/example", "Dr", "Podcast Word Press Link")).url());
  }
}
