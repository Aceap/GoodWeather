package com.aceap.goodweather.ui.place

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.aceap.goodweather.databinding.PlaceItemBinding
import com.aceap.goodweather.logic.model.Place
import com.aceap.goodweather.ui.weather.WeatherActivity

class PlaceAdapter(private val fragment: Fragment, private val placeList: List<Place>) :
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

            Log.d("test", "onCreateViewHolder: $place")
            val intent = Intent(parent.context, WeatherActivity::class.java).apply {
                putExtra("location_lng", String.format("%.4f", place.location.lng.toFloat()))
                putExtra("location_lat", String.format("%.4f", place.location.lat.toFloat()))
                putExtra ("place_name", place.name)
            }
            Log.d("test", "onCreateViewHolder: $position")
            Log.d("test", "onCreateViewHolder: ${parent.context}")
            startActivity(parent.context, intent, null)
            fragment.activity?.finish()
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