package pro.sky.java.weatherfrontend.service;

import pro.sky.java.weatherfrontend.domain.WeatherDto;
import reactor.core.publisher.Mono;

public interface WeatherService {
    Mono<WeatherDto> get(String city);
}
