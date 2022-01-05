package pro.sky.java.weatherfrontend.service

import reactor.core.publisher.Mono
import pro.sky.java.weatherfrontend.domain.Weather

interface WeatherService {
    fun get(city: String): Mono<Weather>
}