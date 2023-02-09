package com.manasbi.date;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service("zonedDateTimeService")
public class ZonedDateTimeService {
  private ZonedDateTimeService() {}

  public static ZonedDateTime convertStringToZonedDateTime(String timeInString) {
    // Eg. timeInString = "Wed, 27 Nov 2019 04:23:06 GMT"
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.RFC_1123_DATE_TIME;
    LocalDateTime localDateTime = LocalDateTime.parse(timeInString, dateTimeFormatter);
    return ZonedDateTime.of(localDateTime, ZoneId.of("Etc/UTC"));
  }
}
