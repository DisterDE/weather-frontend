package pro.sky.java.weatherfrontend.service

import pro.sky.java.weatherfrontend.domain.Weather

interface WeatherService {
    suspend fun get(city: String): Weather
}