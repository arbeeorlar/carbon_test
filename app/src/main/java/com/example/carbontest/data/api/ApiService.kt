package com.example.carbontest.data.api

import com.example.carbontest.data.model.Movie
import io.reactivex.Single

interface ApiService {

    fun getUsers(): Single<Movie>
}