package com.manasbi.controller;

import com.manasbi.constants.ErrorConstants;
import com.manasbi.exception.PodcastEpisodeParseException;
import com.manasbi.model.Channel;
import com.manasbi.model.Episode;
import com.manasbi.parser.ParseAnchorRssFeed;
import com.manasbi.service.ChannelService;
import com.manasbi.service.EpisodesListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PodcastContentController {
  private final ParseAnchorRssFeed parseAnchorRssFeed;

  @Operation(summary = "Gets details about the podcast channel")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Successfully retrieved the details for the podcast channel"),
        @ApiResponse(
            responseCode = "405",
            description = "Only GET method is supported for this endpoint"),
        @ApiResponse(responseCode = "500", description = "Error retrieving podcast channel details")
      })
  @GetMapping(path = "/channel", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody Channel getPodcastChannel() {
    try {
      ChannelService channelService = new ChannelService(parseAnchorRssFeed);
      return channelService.getChannelFromRssFeed();
    } catch (ClassCastException | PodcastEpisodeParseException e) {
      throw new ResponseStatusException(
          HttpStatus.INTERNAL_SERVER_ERROR,
          ErrorConstants.INTERNAL_SERVER_ERROR_PARSING_RSS_FEED,
          e);
    } catch (Exception e) {
      throw new ResponseStatusException(
          HttpStatus.INTERNAL_SERVER_ERROR,
          ErrorConstants.INTERNAL_SERVER_ERROR_RETRIEVING_CHANNEL_DETAILS,
          e);
    }
  }

  @Operation(summary = "Gets details about the podcast episodes")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Successfully retrieved the list of details for the podcast episodes"),
        @ApiResponse(
            responseCode = "405",
            description = "Only GET method is supported for this endpoint"),
        @ApiResponse(
            responseCode = "500",
            description = "Error retrieving podcast episodes details")
      })
  @GetMapping(path = "/episodes", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody List<Episode> getPodcastEpisodes() {
    try {
      EpisodesListService episodesListService = new EpisodesListService(parseAnchorRssFeed);
      return episodesListService.getPodcastEpisodes();
    } catch (ClassCastException | PodcastEpisodeParseException e) {
      throw new ResponseStatusException(
          HttpStatus.INTERNAL_SERVER_ERROR,
          ErrorConstants.INTERNAL_SERVER_ERROR_PARSING_RSS_FEED,
          e);
    } catch (Exception e) {
      throw new ResponseStatusException(
          HttpStatus.INTERNAL_SERVER_ERROR,
          ErrorConstants.INTERNAL_SERVER_ERROR_RETRIEVING_EPISODES_DETAILS,
          e);
    }
  }
}
