package com.lxz.weather_app.repository

import com.lxz.weather_app.server.ApiServices

class CityRepository (val api: ApiServices){

    fun getCities(q : String, limit:Int) =
        api.getCitiesList(q, limit, "e204bbf8ab4feb578a8513130ebc2cfb")

}