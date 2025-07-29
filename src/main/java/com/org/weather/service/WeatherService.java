package com.org.weather.service;

import com.org.weather.client.WeatherClient;
import com.org.weather.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    private final WeatherClient weatherClient;

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public WeatherResponse getWeather(String city) {
        WeatherResponse response = weatherClient.getWeather(city, apiKey);
        convertToCelsius(response);
        return response;
    }

    private void convertToCelsius(WeatherResponse response) {
        if (response.getMain() != null) {
            response.getMain().setTemp(response.getMain().getTemp() - 273.15);
            response.getMain().setFeelsLike(response.getMain().getFeelsLike() - 273.15);
        }
    }
}

