package pro.sky.java.weatherfrontend.domain

class Weather(
    var name: String? = null,
    var main: WeatherMain? = null,
    var weather: List<WeatherDescription>? = null
) {
    override fun toString(): String {
        return "WeatherDto(name=$name, main=$main, weather=$weather)"
    }
}