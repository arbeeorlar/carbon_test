package com.example.carbontest.data.repository

import com.example.carbontest.data.api.ApiHelper
import com.example.carbontest.data.model.Movie
import io.reactivex.Single

class MainRepository(private val apiHelper : ApiHelper) {

    fun getUsers(): Single<Movie> {
        return apiHelper.getUsers()
    }
}