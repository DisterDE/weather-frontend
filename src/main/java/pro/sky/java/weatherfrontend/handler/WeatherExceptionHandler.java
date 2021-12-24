package pro.sky.java.weatherfrontend.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pro.sky.java.weatherfrontend.exception.CityNotFoundException;

@ControllerAdvice
public class WeatherExceptionHandler {

    @ExceptionHandler(CityNotFoundException.class)
    public String cityNotFoundException(CityNotFoundException e, Model model) {
        model.addAttribute("city", e.getCity());
        e.printStackTrace();
        return "error";
    }
}
