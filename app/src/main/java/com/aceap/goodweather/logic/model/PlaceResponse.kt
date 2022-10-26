package com.aceap.goodweather.logic.model

import com.google.gson.annotations.SerializedName

data class PlaceResponse(val status: String, val places: List<Place>)

data class Place(
    val name: String, val location: Location,
    @SerializedName("formatted_address") val address: String,
)

data class Location(var lng: String, var lat: String)