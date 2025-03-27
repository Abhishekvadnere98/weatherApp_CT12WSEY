package com.example.weatherapp.controller;

import com.example.weatherapp.model.WeatherResponse;
import com.example.weatherapp.service.WeatherService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
public class WeatherController {
    
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/getWeather")
    public String getWeather(@RequestParam String city, Model model) {
        WeatherResponse weather = weatherService.getWeather(city);
        model.addAttribute("weather", weather);
        return "index";
    }
}
