package com.manasbi.service;

import com.manasbi.date.ZonedDateTimeService;
import com.manasbi.model.Channel;
import com.manasbi.model.Image;
import com.manasbi.parser.ParseAnchorRssFeed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service("channelService")
@RequiredArgsConstructor
public class ChannelService {
  private final ParseAnchorRssFeed parseAnchorRssFeed;

  public Channel getChannelFromRssFeed() {
    parseAnchorRssFeed.setRssTagFromRSSXmlFeedAfterUnmarshalling();

    Image image =
        new Image(
            parseAnchorRssFeed.getPodcastImage().get(1),
            parseAnchorRssFeed.getPodcastImage().get(1),
            parseAnchorRssFeed.getPodcastImage().get(2));
    ZonedDateTime publishedDate =
        ZonedDateTimeService.convertStringToZonedDateTime(
            parseAnchorRssFeed.getPodcastLastBuildDate());

    return new Channel(
        parseAnchorRssFeed.getPodcastTitle(),
        parseAnchorRssFeed.getPodcastDescription(),
        parseAnchorRssFeed.getPodcastWordPressLink(),
        image,
        parseAnchorRssFeed.getPodcastGenerator(),
        publishedDate,
        parseAnchorRssFeed.getPodcastLinkMetadata(),
        parseAnchorRssFeed.getPodcastAuthor(),
        parseAnchorRssFeed.getPodcastCopyrightOwner(),
        parseAnchorRssFeed.getPodcastLanguageCode(),
        parseAnchorRssFeed.getItunesPodcastType(),
        parseAnchorRssFeed.getItunesPodcastOwnerEmail(),
        parseAnchorRssFeed.getItunesPodcastExplicitFlag(),
        parseAnchorRssFeed.getItunesPodcastCategory(),
        parseAnchorRssFeed.getPodcastEpisodesDetails());
  }
}
