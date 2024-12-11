package com.lxz.weather_app.ViewModel

import androidx.lifecycle.ViewModel
import com.lxz.weather_app.repository.CityRepository
import com.lxz.weather_app.server.ApiClient
import com.lxz.weather_app.server.ApiServices

class CityViewModel(val repository: CityRepository) :ViewModel(){

    constructor():this(CityRepository(ApiClient().getClient().create(ApiServices::class.java)))

    fun loadCity(q:String,limit:Int) = repository.getCities(q, limit)

}