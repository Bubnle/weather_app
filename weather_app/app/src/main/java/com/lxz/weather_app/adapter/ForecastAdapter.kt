package com.lxz.weather_app.adapter

import android.icu.util.Calendar
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lxz.weather_app.databinding.ForecastViewholderBinding
import com.lxz.weather_app.model.ForecastResponseApi
import java.text.SimpleDateFormat


class ForecastAdapter:RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {
    private lateinit var binding: ForecastViewholderBinding

    inner class ViewHolder :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        binding = ForecastViewholderBinding.inflate(inflater,parent,false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ForecastAdapter.ViewHolder, position: Int) {
        val binding = ForecastViewholderBinding.bind(holder.itemView)
        val data = SimpleDateFormat("yyyy-MM-dd HH:mm:SS").parse(differ.currentList[position].dtTxt.toString())
        val calendar = Calendar.getInstance()

        calendar.time = data

        val dayOfWeekName = when(calendar.get(Calendar.DAY_OF_WEEK)){
            1->"Sun"
            2->"Mon"
            3->"Tue"
            4->"Wed"
            5->"Thu"
            6->"Fri"
            7->"Sat"
            else ->"-"
        }
        binding.apply {
            nameDayTxt.text = dayOfWeekName


            val hour = calendar.get(Calendar.HOUR_OF_DAY)

            val amPm = if (hour >= 12) "pm" else "am"

            val hour12 = calendar.get(Calendar.HOUR)

            hourTxt.text = hour12.toString() +amPm
            tempTxt.text = differ.currentList[position].main?.temp?.let {
                Math.round(it)
            }.toString()+"°C"

            val icon = when(differ.currentList[position].weather?.get(0)?.icon.toString()){
                "01d","01n" ->"sunny"
                "02d","02n" ->"cloudy_sunny"
                "03d","03n" ->"cloudy_sunny"
                "04d","04n" ->"cloudy"
                "09d","09n" ->"rainy"
                "10d","10n" ->"rainy"
                "11d","11n" ->"storm"
                "13d","13n" ->"snowy"
                "50d","50n" ->"windy"
                else ->"sunny"
            }

            val drawableResponseId :Int = binding.root.resources.getIdentifier(
                icon,
                "drawable",binding.root.context.packageName
            )

            Glide.with(binding.root.context)
                .load(drawableResponseId)
                .into(binding.plc)
        }

    }

    override fun getItemCount() = differ.currentList.size

    private val differCallback = object :DiffUtil.ItemCallback<ForecastResponseApi.dataW>(){
        override fun areItemsTheSame(
            oldItem: ForecastResponseApi.dataW,
            newItem: ForecastResponseApi.dataW
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ForecastResponseApi.dataW,
            newItem: ForecastResponseApi.dataW
        ): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this,differCallback)
}