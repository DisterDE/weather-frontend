package pro.sky.java.weatherfrontend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.java.weatherfrontend.service.WeatherService;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/get")
    public Mono<String> getWeather(@RequestParam String city, Model model) {
        return weatherService.get(city)
                .doOnSuccess(w -> model.addAttribute("result", w))
                .thenReturn("weather");
    }
}
