package com.sherpa.v1.weather;

import com.sherpa.weather.parse.Address;
import org.springframework.stereotype.Service;
import java.io.UnsupportedEncodingException;

@Service
public interface WeatherService {
    HourlyWeatherDTO getHourlyWeather(Address address) throws UnsupportedEncodingException;
    YesterdayWeatherDTO getYesterdayWeather(Address address) throws UnsupportedEncodingException;
    SummaryWeatherDTO getSummaryWeather(String latitude, String longitude);
    SpecialReportDTO getSpecialReportMessage(Address address) throws UnsupportedEncodingException;
    ThreeDaysUVIndexDTO getThreeDaysUVIndex(String latitude, String longitude);
}
