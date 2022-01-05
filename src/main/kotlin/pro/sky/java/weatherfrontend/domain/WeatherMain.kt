package pro.sky.java.weatherfrontend.domain

class WeatherMain(
    var temp: Int? = null,
    var pressure: Int? = null,
    var humidity: Int? = null
) {
    override fun toString(): String {
        return "WeatherMainDto(temp=$temp, pressure=$pressure, humidity=$humidity)"
    }
}