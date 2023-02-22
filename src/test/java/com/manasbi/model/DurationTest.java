package com.manasbi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DurationTest {
  @Test
  void testConstructor() {
    Duration actualDuration = new Duration(1, 1, 1);

    assertEquals(1, actualDuration.hours());
    assertEquals(1, actualDuration.seconds());
    assertEquals(1, actualDuration.minutes());
  }

  @Test
  void testHours() {
    assertEquals(1, (new Duration(1, 1, 1)).hours());
  }

  @Test
  void testMinutes() {
    assertEquals(1, (new Duration(1, 1, 1)).minutes());
  }

  @Test
  void testSeconds() {
    assertEquals(1, (new Duration(1, 1, 1)).seconds());
  }
}
