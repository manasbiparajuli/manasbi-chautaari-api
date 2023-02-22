package com.manasbi.controller;

import com.manasbi.parser.ParseAnchorRssFeed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PodcastContentController.class, ParseAnchorRssFeed.class})
@ActiveProfiles({"dev"})
@ExtendWith(SpringExtension.class)
class PodcastContentControllerTest {
  @Autowired private PodcastContentController podcastContentController;

  @Test
  void testGetPodcastChannel() throws Exception {
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/channel");
    ResultActions actualPerformResult =
        MockMvcBuilders.standaloneSetup(podcastContentController).build().perform(requestBuilder);
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
  }

  @Test
  void testGetPodcastChannel2() throws Exception {
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/v1/channel", "Uri Variables");
    ResultActions actualPerformResult =
        MockMvcBuilders.standaloneSetup(podcastContentController).build().perform(requestBuilder);
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
  }

  @Test
  void testGetPodcastEpisodes() throws Exception {
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/episodes");
    ResultActions actualPerformResult =
        MockMvcBuilders.standaloneSetup(podcastContentController).build().perform(requestBuilder);
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
  }

  @Test
  void testGetPodcastEpisodes2() throws Exception {
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/episodes");
    getResult.characterEncoding("Encoding");
    ResultActions actualPerformResult =
        MockMvcBuilders.standaloneSetup(podcastContentController).build().perform(getResult);
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
  }
}
