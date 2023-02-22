package com.manasbi.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PodcastErrorController.class})
@ActiveProfiles({"dev"})
@ExtendWith(SpringExtension.class)
class PodcastErrorControllerTest {
  @Autowired private PodcastErrorController podcastErrorController;

  @Test
  void testHandleError() throws Exception {
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/error");
    MockMvcBuilders.standaloneSetup(podcastErrorController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(0))
        .andExpect(MockMvcResultMatchers.view().name("error/404"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("error/404"));
  }

  @Test
  void testHandleError2() throws Exception {
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/error", "Uri Variables");
    MockMvcBuilders.standaloneSetup(podcastErrorController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(0))
        .andExpect(MockMvcResultMatchers.view().name("error/404"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("error/404"));
  }
}
