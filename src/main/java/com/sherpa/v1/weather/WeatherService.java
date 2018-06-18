package com.sherpa.v1.weather;

import com.sherpa.weather.parse.Address;
import org.springframework.stereotype.Service;

@Service
public interface WeatherService {
    HourlyWeatherDTO getHourlyWeather(Address address);
    SummaryWeatherDTO getSummaryWeather(Address address);
    ThreeDaysUVIndexDTO getUVIndex(Address address);
}
