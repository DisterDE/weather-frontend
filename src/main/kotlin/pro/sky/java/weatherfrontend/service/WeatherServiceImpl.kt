package pro.sky.java.weatherfrontend.service

import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import pro.sky.java.weatherfrontend.domain.Weather
import pro.sky.java.weatherfrontend.exception.CityNotFoundException
import reactor.core.publisher.Mono

@Service
class WeatherServiceImpl : WeatherService {

    @Value("\${backend.url}")
    private lateinit var url: String

    private val log = KotlinLogging.logger { }

    override fun get(city: String): Mono<Weather> {
        log.info("Trying to get a forecast for {}", city)
        return WebClient.create()
            .get()
            .uri(url + city)
            .retrieve()
            .bodyToMono(Weather::class.java)
            .doOnSuccess { weatherDto -> log.info("Weather was received: {}", weatherDto) }
            .doOnError { e -> throw CityNotFoundException(city, e) }
    }
}