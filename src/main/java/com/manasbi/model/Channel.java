package com.manasbi.model;

import java.time.ZonedDateTime;
import java.util.List;

public record Channel(
    String title,
    String description,
    String wordPressLink,
    Image podcastImage,
    String podcastGenerator,
    ZonedDateTime podcastLastBuildDate,
    List<String> podcastLinkMetadata,
    String podcastAuthor,
    String podcastCopyrightOwner,
    String podcastLanguageCode,
    String itunesPodcastType,
    String itunesPodcastOwnerEmail,
    Boolean itunesPodcastExplicitFlag,
    String itunesPodcastCategory,
    List<Episode> episodeList) {}
