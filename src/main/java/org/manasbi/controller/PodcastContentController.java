package org.manasbi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PodcastContentController {

    @RequestMapping("/")
    public String getContent() {
        return "Podcast";
    }
}
