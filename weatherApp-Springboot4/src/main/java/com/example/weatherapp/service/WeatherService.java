package com.example.weatherapp.service;

import com.example.weatherapp.model.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Service
public class WeatherService {
    
    private final RestTemplate restTemplate;

    @Value("${weather.api.key}") // Read API Key from properties
    private String apiKey;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherResponse getWeather(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";
        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);
        System.out.println("API Response: " + response); // Log the response
        return response;
    }
}