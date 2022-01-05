package pro.sky.java.weatherfrontend.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import pro.sky.java.weatherfrontend.service.WeatherService

@Controller
class WeatherController(
    private val weatherService: WeatherService
) {
    @GetMapping
    fun index(): String {
        return "index"
    }

    @GetMapping("/get")
    suspend fun getWeather(@RequestParam city: String, model: Model): String {
        return "weather".also {
            model.addAttribute("result", weatherService.get(city))
        }
    }
}