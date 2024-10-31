package com.example.weatherforecast;



import java.util.ArrayList;
import java.util.List;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.WeatherWS;
import cn.com.webxml.WeatherWSSoap;

public class Weather {

    public List<String> getWeather(String cityname) {
        List<String> weatherInfo = new ArrayList<>();
        // 创建实例化对象
        WeatherWS weatherWS = new WeatherWS();
        // 通过实例化对象创建接口
        WeatherWSSoap weatherWSSoap = weatherWS.getWeatherWSSoap();
        // 通过接口传入城市名获取天气信息
        ArrayOfString weather = weatherWSSoap.getWeather(cityname, null);
        if (weather != null) {
            // 将获取到的信息转成集合
            List<String> weathers = weather.getString();
            weatherInfo.addAll(weathers);
        }
        return weatherInfo;
    }

}
