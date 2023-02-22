package com.manasbi.parser;

import com.manasbi.ObjectFactory;
import com.manasbi.Rss;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ContextConfiguration(classes = {ParseAnchorRssFeed.class})
@ActiveProfiles({"dev"})
@ExtendWith(SpringExtension.class)
class ParseAnchorRssFeedTest {
  @Autowired private ParseAnchorRssFeed parseAnchorRssFeed;

  @BeforeEach
  void readPodcastMetadataFromTestResources() throws IOException, JAXBException {
    InputStream input = new ClassPathResource("rssfeed.txt").getInputStream();
    Unmarshaller unmarshaller =
        JAXBContext.newInstance(Rss.class, ObjectFactory.class).createUnmarshaller();
    parseAnchorRssFeed.rssXmlTag = (Rss) unmarshaller.unmarshal(input);
  }

  @Test
  void testSetRssTagFromRSSXmlFeedAfterUnmarshalling() {
    assertEquals("Society & Culture", parseAnchorRssFeed.getItunesPodcastCategory());
    assertEquals(
        "https://manasbichautaari.wordpress.com/", parseAnchorRssFeed.getPodcastWordPressLink());
    assertFalse(parseAnchorRssFeed.getItunesPodcastExplicitFlag());
    assertEquals("episodic", parseAnchorRssFeed.getItunesPodcastType());
    assertEquals("Manasbi Chautaari", parseAnchorRssFeed.getPodcastTitle());
    assertEquals("Thu, 22 Dec 2022 13:57:32 GMT", parseAnchorRssFeed.getPodcastLastBuildDate());
    assertEquals("ne", parseAnchorRssFeed.getPodcastLanguageCode());
    assertEquals("Anchor Podcasts", parseAnchorRssFeed.getPodcastGenerator());
    assertEquals(3, parseAnchorRssFeed.getPodcastImage().size());
    assertEquals(
        "Welcome to the podcast that brings in Nepali people with different interests, careers, and philosophies."
            + " I delve deep into the guest's minds to explore how what and why of any topics I discuss. The podcast"
            + " will be available weekly in the Nepali language. ",
        parseAnchorRssFeed.getPodcastDescription());
    assertEquals("Manasbi Parajuli", parseAnchorRssFeed.getPodcastCopyrightOwner());
    assertEquals("Manasbi Parajuli", parseAnchorRssFeed.getPodcastAuthor());
  }

  @Test
  void testGetPodcastTitle() {
    assertEquals("Manasbi Chautaari", parseAnchorRssFeed.getPodcastTitle());
  }

  @Test
  void testGetPodcastDescription() {
    assertEquals(
        "Welcome to the podcast that brings in Nepali people with different interests, careers, and philosophies. I delve deep into the guest's minds to explore how what and why of any topics I discuss. The podcast will be available weekly in the Nepali language. ",
        parseAnchorRssFeed.getPodcastDescription());
  }

  @Test
  void testGetPodcastWordPressLink() {
    assertEquals(
        "https://manasbichautaari.wordpress.com/", parseAnchorRssFeed.getPodcastWordPressLink());
  }

  @Test
  void testGetPodcastImage() {
    assertEquals("Manasbi Chautaari", parseAnchorRssFeed.getPodcastImage().get(0));
    assertEquals(
        "https://manasbichautaari.wordpress.com/", parseAnchorRssFeed.getPodcastImage().get(1));
    assertEquals(
        "https://d3t3ozftmdmh3i.cloudfront.net/production/podcast_uploaded/2638102/2638102-1573967844417-28d79b44e04c2.jpg",
        parseAnchorRssFeed.getPodcastImage().get(2));
  }

  @Test
  void testGetPodcastGenerator() {
    assertEquals("Anchor Podcasts", parseAnchorRssFeed.getPodcastGenerator());
  }

  @Test
  void testGetPodcastLastBuildDate() {
    assertEquals("Thu, 22 Dec 2022 13:57:32 GMT", parseAnchorRssFeed.getPodcastLastBuildDate());
  }

  @Test
  void testGetPodcastLinkMetadata() {
    assertEquals(
        "https://anchor.fm/s/10520318/podcast/rss",
        parseAnchorRssFeed.getPodcastLinkMetadata().get(0));
    assertEquals("self", parseAnchorRssFeed.getPodcastLinkMetadata().get(1));
    assertEquals("application/rss+xml", parseAnchorRssFeed.getPodcastLinkMetadata().get(2));
  }

  @Test
  void testGetPodcastAuthor() {
    assertEquals("Manasbi Parajuli", parseAnchorRssFeed.getPodcastAuthor());
  }

  @Test
  void testGetPodcastCopyrightOwner() {
    assertEquals("Manasbi Parajuli", parseAnchorRssFeed.getPodcastCopyrightOwner());
  }

  @Test
  void testGetPodcastLanguageCode() {
    assertEquals("ne", parseAnchorRssFeed.getPodcastLanguageCode());
  }

  @Test
  void testGetItunesPodcastType() {
    assertEquals("episodic", parseAnchorRssFeed.getItunesPodcastType());
  }

  @Test
  void testGetItunesPodcastOwnerEmail() {
    assertEquals("manasbiarsenal@gmail.com", parseAnchorRssFeed.getItunesPodcastOwnerEmail());
  }

  @Test
  void testGetItunesPodcastExplicitFlag() {
    assertFalse(parseAnchorRssFeed.getItunesPodcastExplicitFlag());
  }

  @Test
  void testGetItunesPodcastCategory() {
    assertEquals("Society & Culture", parseAnchorRssFeed.getItunesPodcastCategory());
  }

  @Test
  void testGetPodcastEpisodesDetails() {
    assertEquals(18, parseAnchorRssFeed.getPodcastEpisodesDetails().size());
  }
}
