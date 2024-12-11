package com.lxz.weather_app.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.lxz.weather_app.R
import com.lxz.weather_app.ViewModel.WeatherViewModel
import com.lxz.weather_app.adapter.ForecastAdapter
import com.lxz.weather_app.databinding.ActivityMainBinding
import com.lxz.weather_app.model.CurrentResponseApi
import com.lxz.weather_app.model.ForecastResponseApi
import eightbitlab.com.blurview.RenderScriptBlur
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Calendar


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val weatherViewModel: WeatherViewModel by viewModels()
    private val calendar by lazy { Calendar.getInstance() }
    private val forecastAdapter by lazy { ForecastAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            statusBarColor = Color.TRANSPARENT
        }

        binding.apply {

            var lat = intent.getDoubleExtra("lat",0.0)
            var lon = intent.getDoubleExtra("lon",0.0)
            var name = intent.getStringExtra("name")


            if(lat==0.0){
//                lat = 22.54
//                lon = 114.05
//                name = "shenzhen"

                lat=22.2711
                lon=113.5767
                name = "zhuhai"
            }

            addCity.setOnClickListener{
                startActivity(Intent(this@MainActivity,CityListActivity::class.java))
            }

            cityTxt.text = name
            progressBar1.visibility = View.VISIBLE

            // current weather
            weatherViewModel.loadCurrentWeather(lat, lon, "metric").enqueue(
                object : Callback<CurrentResponseApi>{
                    override fun onResponse(
                        call: Call<CurrentResponseApi>,
                        response: Response<CurrentResponseApi>
                    ) {
                        if(response.isSuccessful){
                            val data = response.body()
                            progressBar1.visibility = View.GONE
                            detailLayout.visibility = View.VISIBLE

                            // core code to get the data from the openWeather
                            data?.let {
                                statusTxt.text = it.weather?.get(0)?.main ?: "-"

                                currentTempTxt.text = (it?.main?.temp?.let { Math.round(it) }?.toString() ?: "-") + "°C"
                                maxTempTxt.text = (it?.main?.tempMax?.let { Math.round(it) }?.toString() ?: "-") + "°C"
                                minTempTxt.text = (it?.main?.tempMin?.let { Math.round(it) }?.toString() ?: "-") + "°C"

                                windTxt.text = (it?.wind?.speed?.toString() ?: "-") + " Km"
                                humidityTxt.text = (it?.main?.humidity?.toString() ?: "-") + " %"

                                var drawable = if(isNight()){
                                    R.drawable.night_bg
                                }
                                else{
                                    setDynamicallyWallpaper(it.weather?.get(0)?.icon?: "-" )
                                }
                                bgImage.setImageResource(drawable)
                            }
                        }

                    }
                    override fun onFailure(call: Call<CurrentResponseApi>, t: Throwable) {
                        Toast.makeText(this@MainActivity, t.toString(), Toast.LENGTH_SHORT).show()
                    }
                })



            val radius = 10f;
            val decorView = window.decorView

            val rootView = (decorView.rootView.findViewById(android.R.id.content) as ViewGroup?)
            val windowBackground = decorView.background

            rootView?.let {

                blurView.setupWith(rootView, RenderScriptBlur(this@MainActivity))
                    .setFrameClearDrawable(windowBackground)
                    .setBlurRadius(radius)
                blurView.outlineProvider = ViewOutlineProvider.BACKGROUND
                blurView.clipToOutline = true
            }

            // forecast weather
            weatherViewModel.loadForecastWeather(lat,lon,"metric").enqueue(
                object :Callback<ForecastResponseApi>{
                    override fun onResponse(
                        call: Call<ForecastResponseApi>,
                        response: Response<ForecastResponseApi>
                    ) {
                        if (response.isSuccessful){
                            val data = response.body()
                            blurView.visibility = View.VISIBLE

                            data?.let {
                                forecastAdapter.differ.submitList(it.list)
                                forecastView.apply {
                                    layoutManager = LinearLayoutManager(
                                        this@MainActivity,
                                        LinearLayoutManager.HORIZONTAL,
                                        false)
                                    adapter = forecastAdapter
                                }
                            }
                        }
                    }

                    override fun onFailure(p0: Call<ForecastResponseApi>, t: Throwable) {
                        Toast.makeText(this@MainActivity, t.toString(), Toast.LENGTH_SHORT).show()
                    }

                }
            )

        }


    }

    private fun isNight():Boolean{
        return calendar.get(Calendar.HOUR_OF_DAY) >= 18
    }

     fun setDynamicallyWallpaper(icon: String):Int{
        return when(icon.dropLast(1)){
            "01"->{
                R.drawable.sunny_bg
            }
            "02","03","04"->{
                R.drawable.cloudy_bg
            }
            "09","10","11"->{
                R.drawable.rainy_bg
            }
            "13"->{
                R.drawable.snow_bg
            }
            "50"->{
                R.drawable.haze_bg
            }
            else-> 0
        }
    }

}