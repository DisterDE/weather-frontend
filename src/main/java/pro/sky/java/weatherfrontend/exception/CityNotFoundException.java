package pro.sky.java.weatherfrontend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CityNotFoundException extends RuntimeException {

    private final String city;

    public CityNotFoundException(String city) {
        this.city = city;
    }

    public CityNotFoundException(String city, Throwable e) {
        super(e);
        this.city = city;
    }

    public String getCity() {
        return city;
    }
}
