package com.yc.ifav.service;

import com.yc.ifav.domain.WeatherDomain;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService{


    @Override
    public WeatherDomain getWeather(String province, String city) {
        return new WeatherDomain(province,city);
    }
}
