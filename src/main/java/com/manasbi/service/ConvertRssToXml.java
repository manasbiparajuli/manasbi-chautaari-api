package com.manasbi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service("convertRssToXml")
public class ConvertRssToXml {

  private static final String MANASBI_CHAUTAARI_RSS_FEED_URL =
      "https://anchor.fm/s/10520318/podcast/rss";

  private ConvertRssToXml() {}

  public void convertRssStringFeedToXML() throws IOException {
    URL url = new URL(MANASBI_CHAUTAARI_RSS_FEED_URL);

    try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
      br.lines().forEach(log::info);
    } catch (Exception e) {
      log.error("Error reading RSS Feed {}", e.getMessage());
      throw e;
    }
  }

  public String readXmlContentFromTextFile() throws IOException {
    String xmlOutput;
    try (InputStream input = new ClassPathResource("rssfeed.txt").getInputStream()) {
      byte[] dataAsBytes = FileCopyUtils.copyToByteArray(input);
      xmlOutput = new String(dataAsBytes, StandardCharsets.UTF_8);

    } catch (Exception e) {
      log.error("Error reading RSS Feed {}", e.getMessage());
      throw e;
    }
    return xmlOutput;
  }
}
