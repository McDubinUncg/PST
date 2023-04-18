/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csc340sp23.service;

import com.csc340sp23.api.SportsNewsApi;
import com.csc340sp23.domain.SportsNews;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author those
 */
@Service
public class SportsNewsService {

    public List<SportsNews> getTopSportsNews() {
        SportsNewsApi sportsNewsApi = new SportsNewsApi();
        ResponseEntity<String> response = sportsNewsApi.fetchSportsNews();
        List<SportsNews> sportsNewsList = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(response.getBody());
            JsonNode articles = jsonNode.get("articles");

            for (JsonNode article : articles) {
                String title = article.get("title").asText();
                String url = article.get("url").asText();
                String imageUrl = article.get("urlToImage").asText();

                sportsNewsList.add(new SportsNews(title, url, imageUrl));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sportsNewsList;
    }
}
