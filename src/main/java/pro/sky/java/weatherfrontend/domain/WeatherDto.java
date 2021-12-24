package pro.sky.java.weatherfrontend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherDto {
    private String name;
    private WeatherMainDto main;
    private WeatherDescriptionDto weather;
}
