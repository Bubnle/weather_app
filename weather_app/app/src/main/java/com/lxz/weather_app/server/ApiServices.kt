package com.lxz.weather_app.server

import com.lxz.weather_app.model.CityResponseApi
import com.lxz.weather_app.model.CurrentResponseApi
import com.lxz.weather_app.model.ForecastResponseApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Query

// when use this api can send get request in this mode
interface ApiServices {

    @GET("data/2.5/weather")
    fun getCurrentWeather(
        @Query("lat") lat:Double,
        @Query("lon") lon:Double,
        @Query("units") units:String,
        @Query("appid") appid:String,
    ): Call<CurrentResponseApi>

    @GET("data/2.5/forecast")
    fun getForecastWeather(
        @Query("lat") lat:Double,
        @Query("lon") lon:Double,
        @Query("units") units:String,
        @Query("appid") appid:String,
    ): Call<ForecastResponseApi>

    @GET("geo/1.0/direct")
    fun getCitiesList(
        @Query("q") q:String,
        @Query("limit") limit:Int,
        @Query("appid") appid:String,
    ):Call<CityResponseApi>
}