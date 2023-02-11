package com.manasbi.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RedirectController {
  @GetMapping(path = "/")
  public ModelAndView redirectToSwaggerHomePage(ModelMap modelMap) {
    modelMap.addAttribute("attribute", "/");
    return new ModelAndView("redirect:/api/v1/swagger-ui.html");
  }
}
