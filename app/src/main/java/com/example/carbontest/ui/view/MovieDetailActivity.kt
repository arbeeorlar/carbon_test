package com.example.carbontest.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import androidx.lifecycle.Observer
import com.example.carbontest.R
import com.example.carbontest.ui.main.MovieDetailViewModel
//import io.reactivex.Observer

class MovieDetailActivity : AppCompatActivity() {

    //private val viewModel: MovieDetailViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
    }

//    private fun setupClickListeners() {
//        binding.fragmentButton.setOnClickListener { viewModel.getUpdatedText() }
//    }

    // Observer is waiting for viewModel to update our UI
//    private fun fragmentTextUpdateObserver() {
//        viewModel.uiMovieResults.observe(this, androidx.lifecycle.Observer { updatedText ->
//            print(updatedText.adult)
//            print(updatedText.genre_ids)
//        })
//    }
}