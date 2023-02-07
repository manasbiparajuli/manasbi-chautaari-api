package com.manasbi.service;

import com.manasbi.ObjectFactory;
import com.manasbi.Rss;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;

@Service
public class ParseAnchorRssFeed {

  public static void main(String[] args) throws JAXBException, IOException {
    ParseAnchorRssFeed p = new ParseAnchorRssFeed();
    p.unmarshallXMLToObject();
  }

  public void unmarshallXMLToObject() throws IOException, JAXBException {
    InputStream input = new ClassPathResource("rssfeed.txt").getInputStream();
    Unmarshaller unmarshaller =
        JAXBContext.newInstance(Rss.class, ObjectFactory.class).createUnmarshaller();
    Rss rss = (Rss) unmarshaller.unmarshal(input);
    System.out.println(rss);
    JAXBElement<Rss.Channel.Item> item =
        (JAXBElement<Rss.Channel.Item>) rss.getChannel().getTitleOrDescriptionOrLink().get(32);
    System.out.println(item.getValue().getDescription());
  }
}
