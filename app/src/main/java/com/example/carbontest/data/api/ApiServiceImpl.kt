package com.example.carbontest.data.api

import com.example.carbontest.data.model.Movie
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

class ApiServiceImpl : ApiService {

    override fun getUsers(): Single<Movie> {
        return Rx2AndroidNetworking.get("https://api.themoviedb.org/3/movie/top_rated?api_key=3c4c591112d2efaa1db30d707f144a47&language=en-US&page=1")
            .build()
            .getObjectSingle(Movie::class.java)
    }
}