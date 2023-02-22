package com.manasbi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EpisodeGuidTest {
  @Test
  void testConstructor() {
    assertTrue((new EpisodeGuid("1234", true)).isPermaLink());
  }

  @Test
  void testGuid() {
    assertEquals("1234", (new EpisodeGuid("1234", true)).guid());
  }
}
