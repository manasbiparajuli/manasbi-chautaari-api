package com.manasbi.model;

import java.time.ZonedDateTime;

public record Episode(
    String title,
    String description,
    String link,
    EpisodeGuid episodeGuid,
    String creator,
    ZonedDateTime publishedDate,
    Enclosure enclosure,
    String summary,
    String itunesExplicit,
    Duration duration,
    int itunesSeason,
    int itunesEpisode,
    String itunesEpisodeType) {}
