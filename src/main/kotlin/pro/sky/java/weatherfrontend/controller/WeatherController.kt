package pro.sky.java.weatherfrontend.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import pro.sky.java.weatherfrontend.html.indexPage
import pro.sky.java.weatherfrontend.html.weatherPage
import pro.sky.java.weatherfrontend.service.WeatherService

@RestController
class WeatherController(
    private val weatherService: WeatherService
) {
    @GetMapping
    fun index(): String {
        return indexPage()
    }

    @GetMapping("/get")
    suspend fun getWeather(@RequestParam city: String): String {
        return weatherPage(weatherService.get(city))
    }
}