package pro.sky.java.weatherfrontend.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pro.sky.java.weatherfrontend.domain.WeatherDto;
import pro.sky.java.weatherfrontend.exception.CityNotFoundException;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${backend.url}")
    private String url;

    @Override
    public Mono<WeatherDto> get(String city) {
        log.info("Trying to get a forecast for {}", city);
        return WebClient.create()
                .get()
                .uri(url + city)
                .retrieve()
                .bodyToMono(WeatherDto.class)
                .doOnSuccess(weatherDto -> log.info("Weather was received: {}", weatherDto))
                .doOnError(e -> {
                    throw new CityNotFoundException(city, e);
                });
    }
}
