package com.lxz.weather_app.activity

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.lxz.weather_app.ViewModel.CityViewModel
import com.lxz.weather_app.adapter.CityAdapter
import com.lxz.weather_app.databinding.ActivityCityListBinding
import com.lxz.weather_app.model.CityResponseApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CityListActivity : AppCompatActivity() {

    lateinit var binding: ActivityCityListBinding
    private val cityAdapter by lazy { CityAdapter() }
    private val cityViewModel : CityViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCityListBinding.inflate(layoutInflater)

        setContentView(binding.root)

        window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            statusBarColor = Color.TRANSPARENT
        }

        binding.apply {
            cityEdt.addTextChangedListener(object :TextWatcher{
                override fun beforeTextChanged(
                    p0: CharSequence?,
                    p1: Int,
                    p2: Int,
                    p3: Int
                ) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun afterTextChanged(s: Editable?) {
                    progressBar2.visibility = View.VISIBLE
                    cityViewModel.loadCity(s.toString(),1).enqueue(object :Callback<CityResponseApi> {
                        override fun onResponse(
                            call: Call<CityResponseApi>,
                            response: Response<CityResponseApi>
                        ) {
                            if(response.isSuccessful){
                                val data = response.body()
                                data?.let {
                                    progressBar2.visibility = View.GONE
                                    cityAdapter.differ.submitList(it)
                                    cityView.apply {
                                        layoutManager = LinearLayoutManager(
                                            this@CityListActivity,
                                            LinearLayoutManager.HORIZONTAL,
                                            false
                                        )
                                        adapter = cityAdapter
                                    }
                                }
                            }
                        }

                        override fun onFailure(p0: Call<CityResponseApi>, t: Throwable) {
                            Toast.makeText(this@CityListActivity, t.toString(), Toast.LENGTH_SHORT).show()
                        }

                    })
                }

            })

        }
    }
}