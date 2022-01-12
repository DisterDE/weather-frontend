package pro.sky.java.weatherfrontend.html

import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import pro.sky.java.weatherfrontend.domain.Weather

fun indexPage() = buildString {
    appendHTML().html {
        head { title { +"Weather App" } }
        body {
            h2 { +"Weather App" }
            form(action = "/weather/get", method = FormMethod.get) {
                h3 {
                    p { +"City:" }
                    input(type = InputType.text, name = "city") {
                        placeholder = "Enter the city"
                    }
                }
                button(type = ButtonType.submit) { +"Submit" }
                button(type = ButtonType.reset) { +"Reset" }
            }
        }
    }
}

fun weatherPage(result: Weather) = buildString {
    appendHTML().html {
        head { title { +"Weather in ${result.name}" } }
        body {
            h2 { +"Weather in ${result.name}" }
            result.weather?.get(0)?.icon?.let {
                p { img(src = it) }
            }
            result.main?.temp?.let {
                p {
                    b { +"Temp: " }
                    span { text(it) }
                }
            }
            result.weather?.get(0)?.main?.let {
                p {
                    b { +"Description: " }
                    span { text(it) }
                }
            }
            result.main?.pressure?.let {
                p {
                    b { +"Pressure: " }
                    span { text(it) }
                }
            }
            result.main?.humidity?.let {
                p {
                    b { +"Humidity: " }
                    span { text(it) }
                }
            }

            form(action = "/weather/", method = FormMethod.get) {
                button(type = ButtonType.submit) { +"Back" }
            }
        }
    }
}

fun errorPage(city: String) = buildString {
    appendHTML().html {
        head { title { +"Weather ERROR: $city" } }
        body {
            h2 {
                span {
                    +"City doesn't exist: $city"
                }
            }

            form(action = "/weather/", method = FormMethod.get) {
                button(type = ButtonType.submit) { +"Back" }
            }
        }
    }
}