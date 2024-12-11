package com.lxz.weather_app.repository

import com.lxz.weather_app.server.ApiServices

class WeatherRepository(val api:ApiServices) {

    fun getCurrentWeather(lat : Double, lon:Double, metric:String) =
        api.getCurrentWeather(lat, lon, metric, "e204bbf8ab4feb578a8513130ebc2cfb")

    fun getForecastWeather(lat : Double, lon:Double, metric:String) =
        api.getForecastWeather(lat, lon, metric, "e204bbf8ab4feb578a8513130ebc2cfb")
}