package com.manasbi.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

class PodcastEpisodeParseExceptionTest {
  @Test
  void testConstructor() {
    Throwable throwable = new Throwable();
    assertSame(
        (new PodcastEpisodeParseException("An error occurred", throwable)).getCause(), throwable);
  }
}
