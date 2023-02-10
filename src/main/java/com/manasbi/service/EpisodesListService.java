package com.manasbi.service;

import com.manasbi.model.Episode;
import com.manasbi.parser.ParseAnchorRssFeed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("episodesListService")
@RequiredArgsConstructor
public class EpisodesListService {
  private final ParseAnchorRssFeed parseAnchorRssFeed;

  public List<Episode> getPodcastEpisodes() {
    parseAnchorRssFeed.setRssTagFromRSSXmlFeedAfterUnmarshalling();
    return parseAnchorRssFeed.getPodcastEpisodesDetails();
  }
}
