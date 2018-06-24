package com.sherpa.weather.parse;

import lombok.Data;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Data
public class Address {
    String city;
    String county;
    String village;

    public Address(String city, String county, String village){
        this.city = city;
        this.county = county;
        this.village = village;
    }
    public Address getEncodedAddress() throws UnsupportedEncodingException {
        String enc = "UTF-8";
        return new Address(URLEncoder.encode(city, enc), URLEncoder.encode(county, enc), URLEncoder.encode(village, enc));
    }
}
