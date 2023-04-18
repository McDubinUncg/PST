/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csc340sp23.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author those
 */

public class SportsNewsApi {

    private static final String API_KEY = "8845aff61b5844de9a896fcddbe33d5e";
    private static final String BASE_URL = "https://newsapi.org/v2/top-headlines?country=us&category=sports&apiKey=" + API_KEY;

    public ResponseEntity<String> fetchSportsNews() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL, String.class);
        return response;
    }
}
