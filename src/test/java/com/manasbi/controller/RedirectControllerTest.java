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

@ContextConfiguration(classes = {RedirectController.class})
@ActiveProfiles({"dev"})
@ExtendWith(SpringExtension.class)
class RedirectControllerTest {
  @Autowired private RedirectController redirectController;

  @Test
  void testRedirectToSwaggerHomePage() throws Exception {
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
    MockMvcBuilders.standaloneSetup(redirectController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isFound())
        .andExpect(MockMvcResultMatchers.model().size(1))
        .andExpect(MockMvcResultMatchers.model().attributeExists("attribute"))
        .andExpect(MockMvcResultMatchers.view().name("redirect:/api/v1/swagger-ui.html"))
        .andExpect(MockMvcResultMatchers.redirectedUrl("/api/v1/swagger-ui.html?attribute=%2F"));
  }

  @Test
  void testRedirectToSwaggerHomePage2() throws Exception {
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/", "Uri Variables");
    MockMvcBuilders.standaloneSetup(redirectController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isFound())
        .andExpect(MockMvcResultMatchers.model().size(1))
        .andExpect(MockMvcResultMatchers.model().attributeExists("attribute"))
        .andExpect(MockMvcResultMatchers.view().name("redirect:/api/v1/swagger-ui.html"))
        .andExpect(MockMvcResultMatchers.redirectedUrl("/api/v1/swagger-ui.html?attribute=%2F"));
  }
}
