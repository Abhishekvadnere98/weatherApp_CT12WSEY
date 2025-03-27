Company Name: CodTech IT Solutions
Internship: Java Development
Intern ID: CT12WSEY
Intern Name: Abhishek Vadnere

Introduction
The "Fetching Weather Data" task involves retrieving real-time weather information using Java. This project integrates an external API to collect weather details such as temperature, humidity, wind speed, and weather conditions based on user input (city name or coordinates).

Objectives
Understand API integration in Java.

Fetch and process JSON data.

Display weather information in a user-friendly format.

Technologies Used
Java (Core Java for API requests and data processing)

REST API (OpenWeatherMap or similar API for fetching data)

JSON Parsing (Using Jackson or Gson library)

Maven (For dependency management)

Implementation Steps
1. API Selection & Key Generation
Register on OpenWeatherMap or another weather API provider.

Obtain an API key for authentication.

2. Setting Up Java Project
Create a Maven-based Java project.

Add required dependencies (e.g., org.json, com.google.gson).

3. Making API Requests
Use Java's HttpURLConnection or HttpClient to send GET requests.

Append API key and query parameters (city name or coordinates).

4. Parsing JSON Response
Extract weather details from the API response using JSON parsers.

5. Displaying Data
Format and display temperature, humidity, wind speed, etc., in a readable format.

Code Snippet
java
Copy
Edit
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherFetcher {
    private static final String API_KEY = "your_api_key";
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=";

    public static void main(String[] args) {
        String city = "Mumbai";
        fetchWeather(city);
    }

    public static void fetchWeather(String city) {
        try {
            String urlString = BASE_URL + city + "&appid=" + API_KEY + "&units=metric";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject json = new JSONObject(response.toString());
            System.out.println("City: " + city);
            System.out.println("Temperature: " + json.getJSONObject("main").getDouble("temp") + "°C");
            System.out.println("Humidity: " + json.getJSONObject("main").getInt("humidity") + "%");
            System.out.println("Weather: " + json.getJSONArray("weather").getJSONObject(0).getString("description"));
        } catch (Exception e) {
            System.out.println("Error fetching weather data: " + e.getMessage());
        }
    }
}
