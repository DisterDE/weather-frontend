package pro.sky.java.weatherfrontend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherDescriptionDto {
    private String main;
    private String icon;

    public void setIcon(String icon) {
        if (icon != null) {
            this.icon = "http://openweathermap.org/img/wn/" + icon + "@2x.png";
        }
    }
}
