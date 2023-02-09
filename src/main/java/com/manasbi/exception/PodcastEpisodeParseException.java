package com.manasbi.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PodcastEpisodeParseException extends RuntimeException {
  public PodcastEpisodeParseException(String errorMessage, Throwable err) {
    super(errorMessage, err);
    log.error(errorMessage);
  }
}
