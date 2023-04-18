/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csc340sp23.controller;

import com.csc340sp23.api.SportsNewsApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author those
 */
@RestController
public class SportsNewsController {

    @GetMapping("/sportsnews")
    public ResponseEntity<String> getSportsNews() {
        SportsNewsApi sportsNewsApi = new SportsNewsApi();
        ResponseEntity<String> response = sportsNewsApi.fetchSportsNews();
        return response;
    }
}
