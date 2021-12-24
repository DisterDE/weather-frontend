package pro.sky.java.weatherfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.java.weatherfrontend.service.WeatherService;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/get")
    public String getWeather(@RequestParam String city, Model model) {
        model.addAttribute("result", weatherService.get(city));
        return "weather";
    }
}
