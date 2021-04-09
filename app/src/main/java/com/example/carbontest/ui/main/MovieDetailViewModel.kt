package com.example.carbontest.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carbontest.data.model.MovieResults

class MovieDetailViewModel(val movieResult : MovieResults) : ViewModel(){

    // Create MutableLiveData which MainFragment can subscribe to
    // When this data changes, it triggers the UI to do an update
    val uiMovieResults = MutableLiveData<MovieResults>()

    // Get the updated text from our model and post the value to MainFragment
    fun getUpdatedText() {
        val updatedText = movieResult
        uiMovieResults.postValue(updatedText)
    }


}