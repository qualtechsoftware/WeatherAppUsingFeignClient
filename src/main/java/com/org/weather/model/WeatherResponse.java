package com.org.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class WeatherResponse {

    private Main main;
    private List<Weather> weather;
    @JsonProperty("name")
    private String cityName;

    @Data
    public static class Main {
        private double temp;
        private double feelsLike;
        private double humidity;
    }

    @Data
    public static class Weather {
        private String main;
        private String description;
        private String icon;
    }
}

