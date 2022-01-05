package pro.sky.java.weatherfrontend.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import pro.sky.java.weatherfrontend.service.WeatherService
import reactor.core.publisher.Mono

@Controller
class WeatherController(
    private val weatherService: WeatherService
) {
    @GetMapping
    fun index(): String {
        return "index"
    }

    @GetMapping("/get")
    fun getWeather(@RequestParam city: String, model: Model): Mono<String> {
        return weatherService.get(city)
            .doOnSuccess { w -> model.addAttribute("result", w) }
            .thenReturn("weather")
    }
}