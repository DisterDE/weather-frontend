package pro.sky.java.weatherfrontend.handler

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import pro.sky.java.weatherfrontend.exception.CityNotFoundException
import pro.sky.java.weatherfrontend.html.errorPage

@RestControllerAdvice
class WeatherExceptionHandler {
    @ExceptionHandler(CityNotFoundException::class)
    fun cityNotFoundException(e: CityNotFoundException, model: Model): String {
        return errorPage(e.city).also {
            e.printStackTrace()
        }
    }
}