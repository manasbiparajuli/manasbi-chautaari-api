package com.manasbi.parser;

import com.manasbi.Category;
import com.manasbi.Link;
import com.manasbi.ObjectFactory;
import com.manasbi.Owner;
import com.manasbi.Rss;
import com.manasbi.date.ZonedDateTimeService;
import com.manasbi.exception.PodcastEpisodeParseException;
import com.manasbi.model.Duration;
import com.manasbi.model.Enclosure;
import com.manasbi.model.Episode;
import com.manasbi.model.EpisodeGuid;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import java.net.URL;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service("parseAnchorRssFeed")
@Slf4j
public class ParseAnchorRssFeed {

  private static final String MANASBI_CHAUTAARI_RSS_FEED_URL =
      "https://anchor.fm/s/10520318/podcast/rss";
  Rss rssXmlTag;

  public ParseAnchorRssFeed() {
    rssXmlTag = new Rss();
  }

  @SneakyThrows
  public void setRssTagFromRSSXmlFeedAfterUnmarshalling() {
    Unmarshaller unmarshaller =
        JAXBContext.newInstance(Rss.class, ObjectFactory.class).createUnmarshaller();

    // create unmarshaller from RSS Feed
    rssXmlTag = (Rss) unmarshaller.unmarshal(new URL(MANASBI_CHAUTAARI_RSS_FEED_URL));
  }

  @SneakyThrows
  public String getPodcastTitle() {
    JAXBElement<?> channel =
        (JAXBElement<?>) rssXmlTag.getChannel().getTitleOrDescriptionOrLink().get(0);
    return channel.getValue().toString();
  }

  @SneakyThrows
  public String getPodcastDescription() {
    JAXBElement<?> channel =
        (JAXBElement<?>) rssXmlTag.getChannel().getTitleOrDescriptionOrLink().get(1);
    return channel.getValue().toString();
  }

  @SneakyThrows
  public String getPodcastWordPressLink() {
    JAXBElement<?> channel =
        (JAXBElement<?>) rssXmlTag.getChannel().getTitleOrDescriptionOrLink().get(2);
    return channel.getValue().toString();
  }

  @SneakyThrows
  public List<String> getPodcastImage() {
    JAXBElement<Rss.Channel.Image> channelImage =
        (JAXBElement<Rss.Channel.Image>)
            rssXmlTag.getChannel().getTitleOrDescriptionOrLink().get(3);
    String channelImageUrl = channelImage.getValue().getUrl();
    String channelImageTitle = channelImage.getValue().getTitle();
    String channelImageLink = channelImage.getValue().getLink();

    return List.of(channelImageTitle, channelImageLink, channelImageUrl);
  }

  @SneakyThrows
  public String getPodcastGenerator() {
    JAXBElement<?> channel =
        (JAXBElement<?>) rssXmlTag.getChannel().getTitleOrDescriptionOrLink().get(4);
    return channel.getValue().toString();
  }

  @SneakyThrows
  public String getPodcastLastBuildDate() {
    JAXBElement<?> channel =
        (JAXBElement<?>) rssXmlTag.getChannel().getTitleOrDescriptionOrLink().get(5);
    return channel.getValue().toString();
  }

  @SneakyThrows
  public List<String> getPodcastLinkMetadata() {
    Link link = (Link) rssXmlTag.getChannel().getTitleOrDescriptionOrLink().get(6);
    String linkHref = link.getHref();
    String linkRel = link.getRel();
    String linkType = link.getType();

    return List.of(linkHref, linkRel, linkType);
  }

  @SneakyThrows
  public String getPodcastAuthor() {
    JAXBElement<?> channel =
        (JAXBElement<?>) rssXmlTag.getChannel().getTitleOrDescriptionOrLink().get(7);
    return channel.getValue().toString();
  }

  @SneakyThrows
  public String getPodcastCopyrightOwner() {
    JAXBElement<?> channel =
        (JAXBElement<?>) rssXmlTag.getChannel().getTitleOrDescriptionOrLink().get(8);
    return channel.getValue().toString();
  }

  @SneakyThrows
  public String getPodcastLanguageCode() {
    JAXBElement<?> channel =
        (JAXBElement<?>) rssXmlTag.getChannel().getTitleOrDescriptionOrLink().get(9);
    return channel.getValue().toString();
  }

  @SneakyThrows
  public String getItunesPodcastType() {
    JAXBElement<?> channel =
        (JAXBElement<?>) rssXmlTag.getChannel().getTitleOrDescriptionOrLink().get(13);
    return channel.getValue().toString();
  }

  @SneakyThrows
  public String getItunesPodcastOwnerEmail() {
    Owner owner = (Owner) rssXmlTag.getChannel().getTitleOrDescriptionOrLink().get(14);
    return owner.getEmail();
  }

  @SneakyThrows
  public Boolean getItunesPodcastExplicitFlag() {
    JAXBElement<?> channel =
        (JAXBElement<?>) rssXmlTag.getChannel().getTitleOrDescriptionOrLink().get(15);
    return channel.getValue().toString().equalsIgnoreCase("Yes");
  }

  @SneakyThrows
  public String getItunesPodcastCategory() {
    Category category = (Category) rssXmlTag.getChannel().getTitleOrDescriptionOrLink().get(16);
    return category.getText();
  }

  @SneakyThrows
  public List<Episode> getPodcastEpisodesDetails() {
    List<Episode> episodeList = new ArrayList<>();

    try {
      int titleOrDescriptionOrLinkSizeInXml =
          rssXmlTag.getChannel().getTitleOrDescriptionOrLink().size();
      int episodeStartingIndex = 18;

      for (int episodeIndex = episodeStartingIndex;
          episodeIndex < titleOrDescriptionOrLinkSizeInXml;
          episodeIndex++) {

        JAXBElement<Rss.Channel.Item> item =
            (JAXBElement<Rss.Channel.Item>)
                rssXmlTag.getChannel().getTitleOrDescriptionOrLink().get(episodeIndex);

        EpisodeGuid episodeGuid =
            new EpisodeGuid(
                item.getValue().getGuid().getValue(), item.getValue().getGuid().isIsPermaLink());

        Enclosure enclosure =
            new Enclosure(
                item.getValue().getEnclosure().getUrl(),
                item.getValue().getEnclosure().getLength(),
                item.getValue().getEnclosure().getType());

        ZonedDateTime publishedDate =
            ZonedDateTimeService.convertStringToZonedDateTime(item.getValue().getPubDate());

        Duration duration =
            new Duration(
                item.getValue().getDuration().toGregorianCalendar().toZonedDateTime().getHour(),
                item.getValue().getDuration().toGregorianCalendar().toZonedDateTime().getMinute(),
                item.getValue().getDuration().toGregorianCalendar().toZonedDateTime().getSecond());

        Episode episode =
            new Episode(
                item.getValue().getTitle(),
                item.getValue().getDescription(),
                item.getValue().getLink(),
                episodeGuid,
                item.getValue().getCreator(),
                publishedDate,
                enclosure,
                item.getValue().getSummary(),
                item.getValue().getExplicit(),
                duration,
                item.getValue().getSeason(),
                item.getValue().getEpisode(),
                item.getValue().getEpisodeType());

        assert false;
        episodeList.add(episode);
      }
    } catch (Exception ex) {
      throw new PodcastEpisodeParseException(
          "Error getting episode list details from unmarshaller ", ex);
    }
    return episodeList;
  }
}
