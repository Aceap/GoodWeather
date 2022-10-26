package com.aceap.goodweather.ui.place

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aceap.goodweather.databinding.PlaceItemBinding
import com.aceap.goodweather.logic.model.Place
import com.aceap.goodweather.ui.weather.WeatherActivity

class PlaceAdapter(private val fragment: PlaceFragment, private val placeList: List<Place>) :
    RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {
    inner class ViewHolder(binding: PlaceItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val placeName = binding.placeName
        val placeAddress = binding.placeAddress
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PlaceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = ViewHolder(binding)
        holder.itemView.setOnClickListener {
            val position = holder.bindingAdapterPosition
            val place = placeList[position]
            place.location.lng = String.format("%.4f", place.location.lng.toDouble())
            place.location.lat = String.format("%.4f", place.location.lat.toDouble())
            val activity = fragment.activity
            if (activity is WeatherActivity) {
                activity.getDrawerLayout().closeDrawers()
                activity.viewModel.apply {
                    locationLng = place.location.lng
                    locationLat = place.location.lat
                    placeName = place.name
                }
                activity.refreshWeather()
            } else {
                val intent = Intent(parent.context, WeatherActivity::class.java).apply {
                    putExtra("location_lng", place.location.lng)
                    putExtra("location_lat", place.location.lat)
                    putExtra("place_name", place.name)
                }
                fragment.startActivity(intent)
                fragment.activity?.finish()
            }
            fragment.viewModel.savePlace(place)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = placeList[position]
        holder.placeName.text = data.name
        holder.placeAddress.text = data.address
    }

    override fun getItemCount() = placeList.size
}