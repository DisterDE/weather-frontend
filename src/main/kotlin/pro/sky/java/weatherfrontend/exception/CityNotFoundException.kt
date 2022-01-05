package pro.sky.java.weatherfrontend.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class CityNotFoundException : RuntimeException {

    var city: String

    constructor(city: String) : super() {
        this.city = city
    }

    constructor(city: String, t: Throwable) : super(t) {
        this.city = city
    }
}