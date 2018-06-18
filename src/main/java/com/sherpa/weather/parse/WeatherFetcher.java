package com.sherpa.weather.parse;

import com.google.gson.*;
import com.sherpa.network.APIConfiguration;
import com.sherpa.network.NetworkRequestor;
import com.sherpa.v1.weather.*;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class WeatherFetcher {

    public static WeatherFetcher shared = new WeatherFetcher();

    private WeatherFetcher() {

    }

    public HourlyWeatherDTO fetchHourlyWeather(Address address) throws UnsupportedEncodingException {
        address = address.getEncodedAddress();
        String path = "https://api2.sktelecom.com/weather/current/hourly?version=1&city=" + address.getCity()
                + "&county=" + address.getCounty() + "&village=" + address.getVillage()
                + "&appKey=" + APIConfiguration.sk_AppKey;
        String method = "GET";

        NetworkRequestor requestor = new NetworkRequestor(path, method);
        HourlyWeatherDTO hourlyWeatherDTO = null;
        try {
            requestor.connect();
            String jsonData = requestor.getOutputStream();
            JsonObject jsonObject = new JsonParser().parse(jsonData).getAsJsonObject();
            JsonObject jsonHourly = jsonObject.get("weather").getAsJsonObject().get("hourly").getAsJsonArray().get(0).getAsJsonObject();
            JsonObject jsonCommon = jsonObject.getAsJsonObject("common");

            Gson gson = new Gson();
            HourlyWeather hourlyWeather = gson.fromJson(jsonHourly, HourlyWeather.class);
            hourlyWeather.common = gson.fromJson(jsonCommon, Map.class);
            hourlyWeatherDTO = hourlyWeather.toHourlyWeatherDTO();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hourlyWeatherDTO;
    }

    public YesterdayWeatherDTO fetchYesterdayWeather(Address address) throws UnsupportedEncodingException {
        address = address.getEncodedAddress();
        String path = "https://api2.sktelecom.com/weather/yesterday?version=1&city=" + address.getCity()
                + "&county=" + address.getCounty() + "&village=" + address.getVillage()
                + "&appKey=" + APIConfiguration.sk_AppKey;
        String method = "GET";
        YesterdayWeather yesterdayWeather = null;
        NetworkRequestor requestor = new NetworkRequestor(path, method);
        try {
            requestor.connect();
            String jsonData = requestor.getOutputStream();

            Gson gson = new Gson();
            JsonObject jsonObject = new JsonParser().parse(jsonData).getAsJsonObject();
            JsonObject jsonCommon = jsonObject.getAsJsonObject("common");
            JsonObject jsonDay = jsonObject.getAsJsonObject("weather").getAsJsonArray("yesterday").get(0).getAsJsonObject().getAsJsonObject("day");
            yesterdayWeather = gson.fromJson(jsonDay, YesterdayWeather.class);
            yesterdayWeather.common = gson.fromJson(jsonCommon, Map.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return yesterdayWeather.toYesterdayWeatherDTO();
    }

    public SummaryWeatherDTO fetchSummaryWeather(String latitude, String longitude) {
        String path = "https://api2.sktelecom.com/weather/summary?version=1&lat=" + latitude
                + "&lon=" + longitude
                + "&appKey=" + APIConfiguration.sk_AppKey;
        String method = "GET";

        NetworkRequestor requestor = new NetworkRequestor(path, method);
        SummaryWeatherDTO summaryWeatherDTO = null;
        try {
            requestor.connect();
            String jsonData = requestor.getOutputStream();

            Gson gson = new Gson();
            JsonObject jsonObject = new JsonParser().parse(jsonData).getAsJsonObject();
            JsonObject jsonCommon = jsonObject.getAsJsonObject("common");
            JsonObject jsonWeather = jsonObject
                    .getAsJsonObject("weather")
                    .getAsJsonArray("summary")
                    .get(0).getAsJsonObject();
            SummaryWeather summaryWeather = gson.fromJson(jsonWeather, SummaryWeather.class);
            summaryWeather.common = gson.fromJson(jsonCommon, Map.class);
            summaryWeatherDTO = summaryWeather.toSummaryWeatherDTO();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return summaryWeatherDTO;
    }

    public SpecialReportDTO fetchSpecialReportMessage(Address address) throws UnsupportedEncodingException {
        SpecialReportDTO specialReportDTO = null;
        address = address.getEncodedAddress();
        String path = "https://api2.sktelecom.com/weather/severe/alert?version=1&city=" + address.getCity()
                + "&county=" + address.getCounty() + "&village=" + address.getVillage()
                + "&appKey=" + APIConfiguration.sk_AppKey;
        String method = "GET";
        NetworkRequestor requestor = new NetworkRequestor(path, method);
        try {
            requestor.connect();
            String jsonData = requestor.getOutputStream();

            Gson gson = new Gson();
            JsonObject jsonObject = new JsonParser().parse(jsonData).getAsJsonObject();
            JsonArray jsonArray = jsonObject.getAsJsonObject("weather")
                    .getAsJsonArray("alert");
            if(jsonArray.size() > 0) {
                jsonObject = jsonArray.get(0).getAsJsonObject()
                        .getAsJsonObject("alert60");
                SpecialReport specialReport = gson.fromJson(jsonObject, SpecialReport.class);
                specialReportDTO = specialReport.toSpecialReportDTO();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return specialReportDTO;
    }

    public ThreeDaysUVIndexDTO fetchThreeDaysUVIndex(String latitude, String longitude) {
        String path = "https://api2.sktelecom.com/weather/index/uv?version=1&lat=" + latitude
                + "&lon=" + longitude
                + "&appKey=" + APIConfiguration.sk_AppKey;
        String method = "GET";
        ThreeDaysUVIndexDTO threeDaysUVIndexDTO = null;
        NetworkRequestor requestor = new NetworkRequestor(path, method);
        try {
            requestor.connect();
            String jsonData = requestor.getOutputStream();

            Gson gson = new Gson();
            JsonObject jsonObject = new JsonParser().parse(jsonData).getAsJsonObject();
            jsonObject = jsonObject.getAsJsonObject("weather")
                    .getAsJsonObject("wIndex")
                    .getAsJsonArray("uvindex")
                    .get(0).getAsJsonObject();
            threeDaysUVIndexDTO = gson.fromJson(jsonObject, ThreeDaysUVIndexDTO.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return threeDaysUVIndexDTO;
    }
}
