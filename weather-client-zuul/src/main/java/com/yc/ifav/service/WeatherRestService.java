package com.yc.ifav.service;

import com.google.gson.Gson;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yc.ifav.client.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class WeatherRestService {

    @Autowired
    private WeatherClient weatherClient;

    @HystrixCommand(fallbackMethod = "findAllFallback")
    public String get(String province,String city) {
        return weatherClient.get(province, city);
    }

    private String findAllFallback(String province,String city) {
        Map map = new HashMap();
        map.put("code", "-1");
        map.put("msg", "服务异常");
        return new Gson().toJson(map);
    }
}
