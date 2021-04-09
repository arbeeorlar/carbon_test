package com.example.carbontest.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
	@SerializedName("page") val page : Int,
	@SerializedName("results") val results : List<MovieResults>,
	@SerializedName("total_pages") val total_pages : Int,
	@SerializedName("total_results") val total_results : Int
): Parcelable {}