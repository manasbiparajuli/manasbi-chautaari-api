package com.manasbi.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChannelTest {
  @Test
  void testConstructor() {
    Image image = new Image("https://example.org/example", "Dr", "Podcast Word Press Link");

    ArrayList<String> stringList = new ArrayList<>();
    ArrayList<Episode> episodeList = new ArrayList<>();
    Channel actualChannel =
        new Channel(
            "Dr",
            "The characteristics of someone or something",
            "Word Press Link",
            image,
            "Podcast Generator",
            null,
            stringList,
            "JaneDoe",
            "Podcast Copyright Owner",
            "en",
            "Itunes Podcast Type",
            "jane.doe@example.org",
            true,
            "Itunes Podcast Category",
            episodeList);

    assertEquals("The characteristics of someone or something", actualChannel.description());
    assertEquals("Word Press Link", actualChannel.wordPressLink());
    assertEquals("Dr", actualChannel.title());
    List<String> podcastLinkMetadataResult = actualChannel.podcastLinkMetadata();
    assertSame(stringList, podcastLinkMetadataResult);
    assertEquals(episodeList, podcastLinkMetadataResult);
    assertTrue(podcastLinkMetadataResult.isEmpty());
    assertNull(actualChannel.podcastLastBuildDate());
    assertEquals("en", actualChannel.podcastLanguageCode());
    Image podcastImageResult = actualChannel.podcastImage();
    assertSame(image, podcastImageResult);
    assertEquals("Podcast Generator", actualChannel.podcastGenerator());
    List<Episode> episodeListResult = actualChannel.episodeList();
    assertSame(episodeList, episodeListResult);
    assertEquals(podcastLinkMetadataResult, episodeListResult);
    assertTrue(episodeListResult.isEmpty());
    assertTrue(actualChannel.itunesPodcastExplicitFlag());
    assertEquals("Podcast Copyright Owner", actualChannel.podcastCopyrightOwner());
    assertEquals("jane.doe@example.org", actualChannel.itunesPodcastOwnerEmail());
    assertEquals("JaneDoe", actualChannel.podcastAuthor());
    assertEquals("Itunes Podcast Type", actualChannel.itunesPodcastType());
    assertEquals("Itunes Podcast Category", actualChannel.itunesPodcastCategory());
    assertEquals("Podcast Word Press Link", podcastImageResult.podcastWordPressLink());
    assertEquals("Dr", podcastImageResult.podcastTitle());
    assertEquals("https://example.org/example", podcastImageResult.url());
  }

  @Test
  void testDescription() {
    Image podcastImage = new Image("https://example.org/example", "Dr", "Podcast Word Press Link");

    ArrayList<String> podcastLinkMetadata = new ArrayList<>();
    assertEquals(
        "The characteristics of someone or something",
        (new Channel(
                "Dr",
                "The characteristics of someone or something",
                "Word Press Link",
                podcastImage,
                "Podcast Generator",
                null,
                podcastLinkMetadata,
                "JaneDoe",
                "Podcast Copyright Owner",
                "en",
                "Itunes Podcast Type",
                "jane.doe@example.org",
                true,
                "Itunes Podcast Category",
                new ArrayList<>()))
            .description());
  }

  @Test
  void testEpisodeList() {
    Image podcastImage = new Image("https://example.org/example", "Dr", "Podcast Word Press Link");

    ArrayList<String> podcastLinkMetadata = new ArrayList<>();
    ArrayList<Episode> episodeList = new ArrayList<>();
    List<Episode> actualEpisodeListResult =
        (new Channel(
                "Dr",
                "The characteristics of someone or something",
                "Word Press Link",
                podcastImage,
                "Podcast Generator",
                null,
                podcastLinkMetadata,
                "JaneDoe",
                "Podcast Copyright Owner",
                "en",
                "Itunes Podcast Type",
                "jane.doe@example.org",
                true,
                "Itunes Podcast Category",
                episodeList))
            .episodeList();
    assertSame(episodeList, actualEpisodeListResult);
    assertTrue(actualEpisodeListResult.isEmpty());
  }

  @Test
  void testItunesPodcastCategory() {
    Image podcastImage = new Image("https://example.org/example", "Dr", "Podcast Word Press Link");

    ArrayList<String> podcastLinkMetadata = new ArrayList<>();
    assertEquals(
        "Itunes Podcast Category",
        (new Channel(
                "Dr",
                "The characteristics of someone or something",
                "Word Press Link",
                podcastImage,
                "Podcast Generator",
                null,
                podcastLinkMetadata,
                "JaneDoe",
                "Podcast Copyright Owner",
                "en",
                "Itunes Podcast Type",
                "jane.doe@example.org",
                true,
                "Itunes Podcast Category",
                new ArrayList<>()))
            .itunesPodcastCategory());
  }

  @Test
  void testItunesPodcastExplicitFlag() {
    Image podcastImage = new Image("https://example.org/example", "Dr", "Podcast Word Press Link");

    ArrayList<String> podcastLinkMetadata = new ArrayList<>();
    assertTrue(
        (new Channel(
                "Dr",
                "The characteristics of someone or something",
                "Word Press Link",
                podcastImage,
                "Podcast Generator",
                null,
                podcastLinkMetadata,
                "JaneDoe",
                "Podcast Copyright Owner",
                "en",
                "Itunes Podcast Type",
                "jane.doe@example.org",
                true,
                "Itunes Podcast Category",
                new ArrayList<>()))
            .itunesPodcastExplicitFlag());
  }

  @Test
  void testItunesPodcastExplicitFlag2() {
    Image podcastImage = new Image("https://example.org/example", "Dr", "Podcast Word Press Link");

    ArrayList<String> podcastLinkMetadata = new ArrayList<>();
    assertFalse(
        (new Channel(
                "Dr",
                "The characteristics of someone or something",
                "Word Press Link",
                podcastImage,
                "Podcast Generator",
                null,
                podcastLinkMetadata,
                "JaneDoe",
                "Podcast Copyright Owner",
                "en",
                "Itunes Podcast Type",
                "jane.doe@example.org",
                false,
                "Itunes Podcast Category",
                new ArrayList<>()))
            .itunesPodcastExplicitFlag());
  }

  @Test
  void testItunesPodcastOwnerEmail() {
    Image podcastImage = new Image("https://example.org/example", "Dr", "Podcast Word Press Link");

    ArrayList<String> podcastLinkMetadata = new ArrayList<>();
    assertEquals(
        "jane.doe@example.org",
        (new Channel(
                "Dr",
                "The characteristics of someone or something",
                "Word Press Link",
                podcastImage,
                "Podcast Generator",
                null,
                podcastLinkMetadata,
                "JaneDoe",
                "Podcast Copyright Owner",
                "en",
                "Itunes Podcast Type",
                "jane.doe@example.org",
                true,
                "Itunes Podcast Category",
                new ArrayList<>()))
            .itunesPodcastOwnerEmail());
  }

  @Test
  void testItunesPodcastType() {
    Image podcastImage = new Image("https://example.org/example", "Dr", "Podcast Word Press Link");

    ArrayList<String> podcastLinkMetadata = new ArrayList<>();
    assertEquals(
        "Itunes Podcast Type",
        (new Channel(
                "Dr",
                "The characteristics of someone or something",
                "Word Press Link",
                podcastImage,
                "Podcast Generator",
                null,
                podcastLinkMetadata,
                "JaneDoe",
                "Podcast Copyright Owner",
                "en",
                "Itunes Podcast Type",
                "jane.doe@example.org",
                true,
                "Itunes Podcast Category",
                new ArrayList<>()))
            .itunesPodcastType());
  }

  @Test
  void testPodcastAuthor() {
    Image podcastImage = new Image("https://example.org/example", "Dr", "Podcast Word Press Link");

    ArrayList<String> podcastLinkMetadata = new ArrayList<>();
    assertEquals(
        "JaneDoe",
        (new Channel(
                "Dr",
                "The characteristics of someone or something",
                "Word Press Link",
                podcastImage,
                "Podcast Generator",
                null,
                podcastLinkMetadata,
                "JaneDoe",
                "Podcast Copyright Owner",
                "en",
                "Itunes Podcast Type",
                "jane.doe@example.org",
                true,
                "Itunes Podcast Category",
                new ArrayList<>()))
            .podcastAuthor());
  }

  @Test
  void testPodcastCopyrightOwner() {
    Image podcastImage = new Image("https://example.org/example", "Dr", "Podcast Word Press Link");

    ArrayList<String> podcastLinkMetadata = new ArrayList<>();
    assertEquals(
        "Podcast Copyright Owner",
        (new Channel(
                "Dr",
                "The characteristics of someone or something",
                "Word Press Link",
                podcastImage,
                "Podcast Generator",
                null,
                podcastLinkMetadata,
                "JaneDoe",
                "Podcast Copyright Owner",
                "en",
                "Itunes Podcast Type",
                "jane.doe@example.org",
                true,
                "Itunes Podcast Category",
                new ArrayList<>()))
            .podcastCopyrightOwner());
  }

  @Test
  void testPodcastGenerator() {
    Image podcastImage = new Image("https://example.org/example", "Dr", "Podcast Word Press Link");

    ArrayList<String> podcastLinkMetadata = new ArrayList<>();
    assertEquals(
        "Podcast Generator",
        (new Channel(
                "Dr",
                "The characteristics of someone or something",
                "Word Press Link",
                podcastImage,
                "Podcast Generator",
                null,
                podcastLinkMetadata,
                "JaneDoe",
                "Podcast Copyright Owner",
                "en",
                "Itunes Podcast Type",
                "jane.doe@example.org",
                true,
                "Itunes Podcast Category",
                new ArrayList<>()))
            .podcastGenerator());
  }

  @Test
  void testPodcastImage() {
    Image image = new Image("https://example.org/example", "Dr", "Podcast Word Press Link");

    ArrayList<String> podcastLinkMetadata = new ArrayList<>();
    assertSame(
        image,
        (new Channel(
                "Dr",
                "The characteristics of someone or something",
                "Word Press Link",
                image,
                "Podcast Generator",
                null,
                podcastLinkMetadata,
                "JaneDoe",
                "Podcast Copyright Owner",
                "en",
                "Itunes Podcast Type",
                "jane.doe@example.org",
                true,
                "Itunes Podcast Category",
                new ArrayList<>()))
            .podcastImage());
  }

  @Test
  void testPodcastLanguageCode() {
    Image podcastImage = new Image("https://example.org/example", "Dr", "Podcast Word Press Link");

    ArrayList<String> podcastLinkMetadata = new ArrayList<>();
    assertEquals(
        "en",
        (new Channel(
                "Dr",
                "The characteristics of someone or something",
                "Word Press Link",
                podcastImage,
                "Podcast Generator",
                null,
                podcastLinkMetadata,
                "JaneDoe",
                "Podcast Copyright Owner",
                "en",
                "Itunes Podcast Type",
                "jane.doe@example.org",
                true,
                "Itunes Podcast Category",
                new ArrayList<>()))
            .podcastLanguageCode());
  }

  @Test
  void testPodcastLastBuildDate() {
    Image podcastImage = new Image("https://example.org/example", "Dr", "Podcast Word Press Link");

    ArrayList<String> podcastLinkMetadata = new ArrayList<>();
    assertNull(
        (new Channel(
                "Dr",
                "The characteristics of someone or something",
                "Word Press Link",
                podcastImage,
                "Podcast Generator",
                null,
                podcastLinkMetadata,
                "JaneDoe",
                "Podcast Copyright Owner",
                "en",
                "Itunes Podcast Type",
                "jane.doe@example.org",
                true,
                "Itunes Podcast Category",
                new ArrayList<>()))
            .podcastLastBuildDate());
  }

  @Test
  void testPodcastLinkMetadata() {
    Image podcastImage = new Image("https://example.org/example", "Dr", "Podcast Word Press Link");

    ArrayList<String> stringList = new ArrayList<>();
    List<String> actualPodcastLinkMetadataResult =
        (new Channel(
                "Dr",
                "The characteristics of someone or something",
                "Word Press Link",
                podcastImage,
                "Podcast Generator",
                null,
                stringList,
                "JaneDoe",
                "Podcast Copyright Owner",
                "en",
                "Itunes Podcast Type",
                "jane.doe@example.org",
                true,
                "Itunes Podcast Category",
                new ArrayList<>()))
            .podcastLinkMetadata();
    assertSame(stringList, actualPodcastLinkMetadataResult);
    assertTrue(actualPodcastLinkMetadataResult.isEmpty());
  }

  @Test
  void testTitle() {
    Image podcastImage = new Image("https://example.org/example", "Dr", "Podcast Word Press Link");

    ArrayList<String> podcastLinkMetadata = new ArrayList<>();
    assertEquals(
        "Dr",
        (new Channel(
                "Dr",
                "The characteristics of someone or something",
                "Word Press Link",
                podcastImage,
                "Podcast Generator",
                null,
                podcastLinkMetadata,
                "JaneDoe",
                "Podcast Copyright Owner",
                "en",
                "Itunes Podcast Type",
                "jane.doe@example.org",
                true,
                "Itunes Podcast Category",
                new ArrayList<>()))
            .title());
  }

  @Test
  void testWordPressLink() {
    Image podcastImage = new Image("https://example.org/example", "Dr", "Podcast Word Press Link");

    ArrayList<String> podcastLinkMetadata = new ArrayList<>();
    assertEquals(
        "Word Press Link",
        (new Channel(
                "Dr",
                "The characteristics of someone or something",
                "Word Press Link",
                podcastImage,
                "Podcast Generator",
                null,
                podcastLinkMetadata,
                "JaneDoe",
                "Podcast Copyright Owner",
                "en",
                "Itunes Podcast Type",
                "jane.doe@example.org",
                true,
                "Itunes Podcast Category",
                new ArrayList<>()))
            .wordPressLink());
  }
}
