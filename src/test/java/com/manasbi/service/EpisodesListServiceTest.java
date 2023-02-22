package com.manasbi.service;

import com.manasbi.model.Episode;
import com.manasbi.parser.ParseAnchorRssFeed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {EpisodesListService.class})
@ActiveProfiles({"dev"})
@ExtendWith(SpringExtension.class)
class EpisodesListServiceTest {
  @Autowired private EpisodesListService episodesListService;

  @MockBean(name = "parseAnchorRssFeed")
  private ParseAnchorRssFeed parseAnchorRssFeed;

  @Test
  void testGetPodcastEpisodes() {
    ArrayList<Episode> episodeList = new ArrayList<>();
    when(parseAnchorRssFeed.getPodcastEpisodesDetails()).thenReturn(episodeList);
    doNothing().when(parseAnchorRssFeed).setRssTagFromRSSXmlFeedAfterUnmarshalling();
    List<Episode> actualPodcastEpisodes = episodesListService.getPodcastEpisodes();
    assertSame(episodeList, actualPodcastEpisodes);
    assertTrue(actualPodcastEpisodes.isEmpty());
    verify(parseAnchorRssFeed).getPodcastEpisodesDetails();
    verify(parseAnchorRssFeed).setRssTagFromRSSXmlFeedAfterUnmarshalling();
  }
}
