package com.sherpa.main;

import com.sherpa.exception.CustomError;
import com.sherpa.network.ResponseUtil;
import com.sherpa.v1.weather.WeatherServiceImpl;
import com.sherpa.weather.parse.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@RestController
public class WeatherController {
    @Autowired
    private WeatherServiceImpl weatherServiceImpl;

    @RequestMapping(value = "/getHourlyWeather", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getHourlyWeather(@RequestParam("city") String city, @RequestParam("county") String county, @RequestParam("village") String village) {
        Address address = new Address(city, county, village);
        try {
            return ResponseUtil.success(weatherServiceImpl.getHourlyWeather(address));
        } catch (UnsupportedEncodingException e) {
            return ResponseUtil.exceptionError(CustomError.URL_ENCODING_ERROR.code, CustomError.URL_ENCODING_ERROR.message);
        } catch (Exception e) {
            return ResponseUtil.exceptionError(CustomError.NO_HOURLY_WEATHER.code, CustomError.NO_HOURLY_WEATHER.message);
        }
    }

    @RequestMapping(value = "/getYesterdayWeather", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getYesterdayWeather(@RequestParam("city") String city, @RequestParam("county") String county, @RequestParam("village") String village) {
        Address address = new Address(city, county, village);
        try {
            return ResponseUtil.success(weatherServiceImpl.getYesterdayWeather(address));
        } catch (UnsupportedEncodingException e) {
            return ResponseUtil.exceptionError(CustomError.URL_ENCODING_ERROR.code, CustomError.URL_ENCODING_ERROR.message);
        } catch (Exception e) {
            return ResponseUtil.exceptionError(CustomError.NO_YESTERDAY_WEATHER.code, CustomError.NO_YESTERDAY_WEATHER.message);
        }
    }

    @RequestMapping(value = "/getSpecialReportMessage", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getSpecialReportMessage(@RequestParam("city") String city, @RequestParam("county") String county, @RequestParam("village") String village) {
        Address address = new Address(city, county, village);
        try {
            return ResponseUtil.success(weatherServiceImpl.getSpecialReportMessage(address));
        } catch (UnsupportedEncodingException e) {
            return ResponseUtil.exceptionError(CustomError.URL_ENCODING_ERROR.code, CustomError.URL_ENCODING_ERROR.message);
        } catch (Exception e) {
            return ResponseUtil.exceptionError(CustomError.NO_WEATHER_SPECIAL_REPORT.code, CustomError.NO_WEATHER_SPECIAL_REPORT.message);
        }
    }

    @RequestMapping(value = "/getThreeDaysUVIndex", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getThreeDaysUVIndex(@RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude) {
        try {
            return ResponseUtil.success(weatherServiceImpl.getThreeDaysUVIndex(latitude, longitude));
        } catch (Exception e) {
            return ResponseUtil.exceptionError(CustomError.NO_UV_INDEX_ERROR.code, CustomError.NO_UV_INDEX_ERROR.message);
        }
    }
}
