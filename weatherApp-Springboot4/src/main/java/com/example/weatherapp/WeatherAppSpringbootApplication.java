package com.example.weatherapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.awt.*;
import java.net.URI;

@SpringBootApplication
public class WeatherAppSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherAppSpringbootApplication.class, args);

        System.out.println("Application started. Waiting for server to initialize...");
        try {
            Thread.sleep(10000); // 10 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Attempting to open browser...");
        openHomePage();
    }

    private static void openHomePage() {
        String url = "http://localhost:8080";
        String os = System.getProperty("os.name").toLowerCase();
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            } else if (os.contains("win")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if (os.contains("mac")) {
                Runtime.getRuntime().exec("open " + url);
            } else if (os.contains("nix") || os.contains("nux")) {
                Runtime.getRuntime().exec("xdg-open " + url);
            } else {
                System.out.println("Unsupported operating system.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}