package pro.sky.java.weatherfrontend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherMainDto {
    private Integer temp;
    private Integer pressure;
    private Integer humidity;
}
