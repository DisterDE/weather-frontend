package pro.sky.java.weatherfrontend.domain

class WeatherDescription {
    var main: String? = null
    var icon: String? = null
        set(value) {
            field = "https://openweathermap.org/img/wn/$value@2x.png"
        }

    override fun toString(): String {
        return "WeatherDescriptionDto(main=$main, icon=$icon)"
    }
}