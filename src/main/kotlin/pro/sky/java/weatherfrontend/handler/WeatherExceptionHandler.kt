package pro.sky.java.weatherfrontend.handler

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import pro.sky.java.weatherfrontend.exception.CityNotFoundException

@ControllerAdvice
class WeatherExceptionHandler {
    @ExceptionHandler(CityNotFoundException::class)
    fun cityNotFoundException(e: CityNotFoundException, model: Model): String {
        return "error".also {
            model.addAttribute("city", e.city)
            e.printStackTrace()
        }
    }
}