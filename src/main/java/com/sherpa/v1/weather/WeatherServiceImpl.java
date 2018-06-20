package com.sherpa.v1.weather;

import com.sherpa.weather.parse.Address;
import com.sherpa.weather.parse.WeatherFetcher;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Override
    public HourlyWeatherDTO getHourlyWeather(Address address) throws UnsupportedEncodingException {
        HourlyWeatherDTO hourlyWeatherDTO = WeatherFetcher.shared.fetchHourlyWeather(address);
        ThreeDaysUVIndexDTO threeDaysUVIndexDTO = WeatherFetcher.shared.fetchThreeDaysUVIndex(hourlyWeatherDTO.getLatitude(), hourlyWeatherDTO.getLongitude());
        hourlyWeatherDTO.setUvIndex(threeDaysUVIndexDTO.getToday().getIndex());
        hourlyWeatherDTO.setUvComment(threeDaysUVIndexDTO.getToday().getComment());
        if(hourlyWeatherDTO.getAlertYn().equals("Y")) {
            SpecialReportDTO specialReportDTO = WeatherFetcher.shared.fetchSpecialReportMessage(address);
            hourlyWeatherDTO.setAlertSummary(specialReportDTO.getAlertSummary());
            hourlyWeatherDTO.setAlertMessage(specialReportDTO.getAlertMessage());
        }
        return hourlyWeatherDTO;
    }

    @Override
    public YesterdayWeatherDTO getYesterdayWeather(Address address) throws UnsupportedEncodingException {
        YesterdayWeatherDTO yesterdayWeatherDTO = WeatherFetcher.shared.fetchYesterdayWeather(address);
        ThreeDaysUVIndexDTO threeDaysUVIndexDTO = WeatherFetcher.shared.fetchThreeDaysUVIndex(yesterdayWeatherDTO.getLatitude(), yesterdayWeatherDTO.getLongitude());
        yesterdayWeatherDTO.setUvIndex(threeDaysUVIndexDTO.getToday().getIndex());
        yesterdayWeatherDTO.setUvComment(threeDaysUVIndexDTO.getToday().getComment());
        return yesterdayWeatherDTO;
    }

    @Override
    public SummaryWeatherDTO getSummaryWeather(String latitude, String longitude) {
        return WeatherFetcher.shared.fetchSummaryWeather(latitude, longitude);
    }

    @Override
    public SpecialReportDTO getSpecialReportMessage(Address address) throws UnsupportedEncodingException {
        return WeatherFetcher.shared.fetchSpecialReportMessage(address);
    }

    @Override
    public ThreeDaysUVIndexDTO getThreeDaysUVIndex(String latitude, String longitude) {
        return WeatherFetcher.shared.fetchThreeDaysUVIndex(latitude, longitude);
    }
}
