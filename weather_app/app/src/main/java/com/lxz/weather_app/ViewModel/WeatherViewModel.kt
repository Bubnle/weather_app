package com.lxz.weather_app.ViewModel

import androidx.lifecycle.ViewModel
import com.lxz.weather_app.repository.WeatherRepository
import com.lxz.weather_app.server.ApiClient
import com.lxz.weather_app.server.ApiServices


class WeatherViewModel(val repository: WeatherRepository):ViewModel() {

    // constructor to create a client who use this api
    constructor():this(WeatherRepository(ApiClient().getClient().create(ApiServices::class.java)))

    fun loadCurrentWeather(lat:Double, lng: Double, metric :String) =
        repository.getCurrentWeather(lat, lng, metric)

    fun loadForecastWeather(lat:Double, lng: Double, metric :String) =
        repository.getForecastWeather(lat, lng, metric)
}