package pro.sky.java.weatherfrontend.service;

import pro.sky.java.weatherfrontend.domain.WeatherDto;

public interface WeatherService {
    WeatherDto get(String city);
}
