package pro.sky.java.weatherfrontend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WeatherFrontendApplication

fun main(args: Array<String>) {
    runApplication<WeatherFrontendApplication>(*args)
}