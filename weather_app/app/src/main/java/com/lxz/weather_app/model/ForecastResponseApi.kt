package com.lxz.weather_app.model


import com.google.gson.annotations.SerializedName

data class ForecastResponseApi(
    @SerializedName("city")
    val city: City?,
    @SerializedName("cnt")
    val cnt: Int?, // 40
    @SerializedName("cod")
    val cod: String?, // 200
    @SerializedName("list")
    val list: List<dataW?>?,
    @SerializedName("message")
    val message: Int? // 0
) {
    data class City(
        @SerializedName("coord")
        val coord: Coord?,
        @SerializedName("country")
        val country: String?, // IT
        @SerializedName("id")
        val id: Int?, // 3163858
        @SerializedName("name")
        val name: String?, // Zocca
        @SerializedName("population")
        val population: Int?, // 4593
        @SerializedName("sunrise")
        val sunrise: Int?, // 1661834187
        @SerializedName("sunset")
        val sunset: Int?, // 1661882248
        @SerializedName("timezone")
        val timezone: Int? // 7200
    ) {
        data class Coord(
            @SerializedName("lat")
            val lat: Double?, // 44.34
            @SerializedName("lon")
            val lon: Double? // 10.99
        )
    }

    data class dataW(
        @SerializedName("clouds")
        val clouds: Clouds?,
        @SerializedName("dt")
        val dt: Int?, // 1661871600
        @SerializedName("dt_txt")
        val dtTxt: String?, // 2022-08-30 15:00:00
        @SerializedName("main")
        val main: Main?,
        @SerializedName("pop")
        val pop: Double?, // 0.32
        @SerializedName("rain")
        val rain: Rain?,
        @SerializedName("sys")
        val sys: Sys?,
        @SerializedName("visibility")
        val visibility: Int?, // 10000
        @SerializedName("weather")
        val weather: List<Weather?>?,
        @SerializedName("wind")
        val wind: Wind?
    ) {
        data class Clouds(
            @SerializedName("all")
            val all: Int? // 100
        )

        data class Main(
            @SerializedName("feels_like")
            val feelsLike: Double?, // 296.98
            @SerializedName("grnd_level")
            val grndLevel: Int?, // 933
            @SerializedName("humidity")
            val humidity: Int?, // 69
            @SerializedName("pressure")
            val pressure: Int?, // 1015
            @SerializedName("sea_level")
            val seaLevel: Int?, // 1015
            @SerializedName("temp")
            val temp: Double?, // 296.76
            @SerializedName("temp_kf")
            val tempKf: Double?, // -1.11
            @SerializedName("temp_max")
            val tempMax: Double?, // 297.87
            @SerializedName("temp_min")
            val tempMin: Double? // 296.76
        )

        data class Rain(
            @SerializedName("3h")
            val h: Double? // 0.26
        )

        data class Sys(
            @SerializedName("pod")
            val pod: String? // d
        )

        data class Weather(
            @SerializedName("description")
            val description: String?, // light rain
            @SerializedName("icon")
            val icon: String?, // 10d
            @SerializedName("id")
            val id: Int?, // 500
            @SerializedName("main")
            val main: String? // Rain
        )

        data class Wind(
            @SerializedName("deg")
            val deg: Int?, // 349
            @SerializedName("gust")
            val gust: Double?, // 1.18
            @SerializedName("speed")
            val speed: Double? // 0.62
        )
    }
}