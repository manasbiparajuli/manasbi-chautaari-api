package com.manasbi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EpisodeTest {
  @Test
  void testConstructor() {
    EpisodeGuid episodeGuid = new EpisodeGuid("1234", true);

    Enclosure enclosure = new Enclosure("https://example.org/example", 3L, "Media Type");

    Duration duration = new Duration(1, 1, 1);

    Episode actualEpisode =
        new Episode(
            "Dr",
            "The characteristics of someone or something",
            "Link",
            episodeGuid,
            "Creator",
            null,
            enclosure,
            "Summary",
            "Itunes Explicit",
            duration,
            1,
            1,
            "Itunes Episode Type");

    assertEquals("Creator", actualEpisode.creator());
    assertEquals("Dr", actualEpisode.title());
    assertEquals("Summary", actualEpisode.summary());
    assertNull(actualEpisode.publishedDate());
    assertEquals("Link", actualEpisode.link());
    assertEquals(1, actualEpisode.itunesSeason());
    assertEquals("Itunes Explicit", actualEpisode.itunesExplicit());
    assertEquals("Itunes Episode Type", actualEpisode.itunesEpisodeType());
    assertEquals(1, actualEpisode.itunesEpisode());

    EpisodeGuid episodeGuidResult = actualEpisode.episodeGuid();
    assertSame(episodeGuid, episodeGuidResult);

    Enclosure enclosureResult = actualEpisode.enclosure();
    assertSame(enclosure, enclosureResult);
    assertEquals("The characteristics of someone or something", actualEpisode.description());

    Duration durationResult = actualEpisode.duration();
    assertSame(duration, durationResult);

    assertEquals("Media Type", enclosureResult.mediaType());
    assertEquals(1, durationResult.seconds());
    assertEquals(1, durationResult.minutes());
    assertEquals(1, durationResult.hours());
    assertEquals(3L, enclosureResult.episodeLength());
    assertEquals("1234", episodeGuidResult.guid());
    assertEquals("https://example.org/example", enclosureResult.url());
    assertTrue(episodeGuidResult.isPermaLink());
  }

  @Test
  void testCreator() {
    EpisodeGuid episodeGuid = new EpisodeGuid("1234", true);

    Enclosure enclosure = new Enclosure("https://example.org/example", 3L, "Media Type");

    assertEquals(
        "Creator",
        (new Episode(
                "Dr",
                "The characteristics of someone or something",
                "Link",
                episodeGuid,
                "Creator",
                null,
                enclosure,
                "Summary",
                "Itunes Explicit",
                new Duration(1, 1, 1),
                1,
                1,
                "Itunes Episode Type"))
            .creator());
  }

  @Test
  void testDescription() {
    EpisodeGuid episodeGuid = new EpisodeGuid("1234", true);

    Enclosure enclosure = new Enclosure("https://example.org/example", 3L, "Media Type");

    assertEquals(
        "The characteristics of someone or something",
        (new Episode(
                "Dr",
                "The characteristics of someone or something",
                "Link",
                episodeGuid,
                "Creator",
                null,
                enclosure,
                "Summary",
                "Itunes Explicit",
                new Duration(1, 1, 1),
                1,
                1,
                "Itunes Episode Type"))
            .description());
  }

  @Test
  void testDuration() {
    EpisodeGuid episodeGuid = new EpisodeGuid("1234", true);

    Enclosure enclosure = new Enclosure("https://example.org/example", 3L, "Media Type");

    Duration duration = new Duration(1, 1, 1);

    assertSame(
        duration,
        (new Episode(
                "Dr",
                "The characteristics of someone or something",
                "Link",
                episodeGuid,
                "Creator",
                null,
                enclosure,
                "Summary",
                "Itunes Explicit",
                duration,
                1,
                1,
                "Itunes Episode Type"))
            .duration());
  }

  @Test
  void testEnclosure() {
    EpisodeGuid episodeGuid = new EpisodeGuid("1234", true);

    Enclosure enclosure = new Enclosure("https://example.org/example", 3L, "Media Type");

    assertSame(
        enclosure,
        (new Episode(
                "Dr",
                "The characteristics of someone or something",
                "Link",
                episodeGuid,
                "Creator",
                null,
                enclosure,
                "Summary",
                "Itunes Explicit",
                new Duration(1, 1, 1),
                1,
                1,
                "Itunes Episode Type"))
            .enclosure());
  }

  @Test
  void testEpisodeGuid() {
    EpisodeGuid episodeGuid = new EpisodeGuid("1234", true);

    Enclosure enclosure = new Enclosure("https://example.org/example", 3L, "Media Type");

    assertSame(
        episodeGuid,
        (new Episode(
                "Dr",
                "The characteristics of someone or something",
                "Link",
                episodeGuid,
                "Creator",
                null,
                enclosure,
                "Summary",
                "Itunes Explicit",
                new Duration(1, 1, 1),
                1,
                1,
                "Itunes Episode Type"))
            .episodeGuid());
  }

  @Test
  void testItunesEpisode() {
    EpisodeGuid episodeGuid = new EpisodeGuid("1234", true);

    Enclosure enclosure = new Enclosure("https://example.org/example", 3L, "Media Type");

    assertEquals(
        1,
        (new Episode(
                "Dr",
                "The characteristics of someone or something",
                "Link",
                episodeGuid,
                "Creator",
                null,
                enclosure,
                "Summary",
                "Itunes Explicit",
                new Duration(1, 1, 1),
                1,
                1,
                "Itunes Episode Type"))
            .itunesEpisode());
  }

  @Test
  void testItunesEpisodeType() {
    EpisodeGuid episodeGuid = new EpisodeGuid("1234", true);

    Enclosure enclosure = new Enclosure("https://example.org/example", 3L, "Media Type");

    assertEquals(
        "Itunes Episode Type",
        (new Episode(
                "Dr",
                "The characteristics of someone or something",
                "Link",
                episodeGuid,
                "Creator",
                null,
                enclosure,
                "Summary",
                "Itunes Explicit",
                new Duration(1, 1, 1),
                1,
                1,
                "Itunes Episode Type"))
            .itunesEpisodeType());
  }

  @Test
  void testItunesExplicit() {
    EpisodeGuid episodeGuid = new EpisodeGuid("1234", true);

    Enclosure enclosure = new Enclosure("https://example.org/example", 3L, "Media Type");

    assertEquals(
        "Itunes Explicit",
        (new Episode(
                "Dr",
                "The characteristics of someone or something",
                "Link",
                episodeGuid,
                "Creator",
                null,
                enclosure,
                "Summary",
                "Itunes Explicit",
                new Duration(1, 1, 1),
                1,
                1,
                "Itunes Episode Type"))
            .itunesExplicit());
  }

  @Test
  void testItunesSeason() {
    EpisodeGuid episodeGuid = new EpisodeGuid("1234", true);

    Enclosure enclosure = new Enclosure("https://example.org/example", 3L, "Media Type");

    assertEquals(
        1,
        (new Episode(
                "Dr",
                "The characteristics of someone or something",
                "Link",
                episodeGuid,
                "Creator",
                null,
                enclosure,
                "Summary",
                "Itunes Explicit",
                new Duration(1, 1, 1),
                1,
                1,
                "Itunes Episode Type"))
            .itunesSeason());
  }

  @Test
  void testLink() {
    EpisodeGuid episodeGuid = new EpisodeGuid("1234", true);

    Enclosure enclosure = new Enclosure("https://example.org/example", 3L, "Media Type");

    assertEquals(
        "Link",
        (new Episode(
                "Dr",
                "The characteristics of someone or something",
                "Link",
                episodeGuid,
                "Creator",
                null,
                enclosure,
                "Summary",
                "Itunes Explicit",
                new Duration(1, 1, 1),
                1,
                1,
                "Itunes Episode Type"))
            .link());
  }

  @Test
  void testPublishedDate() {
    EpisodeGuid episodeGuid = new EpisodeGuid("1234", true);

    Enclosure enclosure = new Enclosure("https://example.org/example", 3L, "Media Type");

    assertNull(
        (new Episode(
                "Dr",
                "The characteristics of someone or something",
                "Link",
                episodeGuid,
                "Creator",
                null,
                enclosure,
                "Summary",
                "Itunes Explicit",
                new Duration(1, 1, 1),
                1,
                1,
                "Itunes Episode Type"))
            .publishedDate());
  }

  @Test
  void testSummary() {
    EpisodeGuid episodeGuid = new EpisodeGuid("1234", true);

    Enclosure enclosure = new Enclosure("https://example.org/example", 3L, "Media Type");

    assertEquals(
        "Summary",
        (new Episode(
                "Dr",
                "The characteristics of someone or something",
                "Link",
                episodeGuid,
                "Creator",
                null,
                enclosure,
                "Summary",
                "Itunes Explicit",
                new Duration(1, 1, 1),
                1,
                1,
                "Itunes Episode Type"))
            .summary());
  }

  @Test
  void testTitle() {
    EpisodeGuid episodeGuid = new EpisodeGuid("1234", true);

    Enclosure enclosure = new Enclosure("https://example.org/example", 3L, "Media Type");

    assertEquals(
        "Dr",
        (new Episode(
                "Dr",
                "The characteristics of someone or something",
                "Link",
                episodeGuid,
                "Creator",
                null,
                enclosure,
                "Summary",
                "Itunes Explicit",
                new Duration(1, 1, 1),
                1,
                1,
                "Itunes Episode Type"))
            .title());
  }
}
