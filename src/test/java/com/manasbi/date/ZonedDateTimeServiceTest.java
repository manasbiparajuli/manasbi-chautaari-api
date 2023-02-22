package com.manasbi.date;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZonedDateTimeServiceTest {
  @Test
  void testConvertStringToZonedDateTime() {
    ZonedDateTime actualZonedDateTime =
        ZonedDateTimeService.convertStringToZonedDateTime("Wed, 27 Nov 2019 04:23:06 GMT");
    assertEquals(2019, actualZonedDateTime.getYear());
    assertEquals(11, actualZonedDateTime.getMonthValue());
    assertEquals(27, actualZonedDateTime.getDayOfMonth());
    assertEquals(DayOfWeek.WEDNESDAY, actualZonedDateTime.getDayOfWeek());
    assertEquals(4, actualZonedDateTime.getHour());
    assertEquals(23, actualZonedDateTime.getMinute());
    assertEquals(6, actualZonedDateTime.getSecond());
    assertEquals(ZoneId.of("Etc/UTC"), actualZonedDateTime.getZone());
  }
}
