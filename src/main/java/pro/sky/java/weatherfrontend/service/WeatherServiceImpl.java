package pro.sky.java.weatherfrontend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pro.sky.java.weatherfrontend.domain.WeatherDto;
import pro.sky.java.weatherfrontend.exception.CityNotFoundException;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final RestTemplate restTemplate;

    @Value("${backend.url}")
    private String url;

    public WeatherServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public WeatherDto get(String city) {
        try {
            return restTemplate.getForObject(url + city, WeatherDto.class);
        } catch (RestClientException e) {
            throw new CityNotFoundException(city, e);
        }
    }
}
