package com.example.carbontest.ui.main

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.carbontest.R
import com.example.carbontest.data.model.MovieResults
import com.example.carbontest.ui.view.MovieDetailActivity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_item.view.*


class MainAdapter(
    private val users: ArrayList<MovieResults>,
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {


    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {


        init {
            itemView.setOnClickListener(this)
        }

        fun bind(movie: MovieResults) {
            itemView.movieTitle.text = "Title:${movie.title}"
            itemView.description.text = "${movie.overview.substring(0, 55)}..."
            Picasso.get()
                .load("https://api.themoviedb.org${movie.poster_path}")
                //.placeholder(R.mipmap.holly_wood)
                .into(itemView.movieImg, object : com.squareup.picasso.Callback {
                    override fun onSuccess() {
                        itemView.progressView.isVisible = false;
                    }

                    override fun onError(e: java.lang.Exception?) {
                        itemView.movieImg.isVisible = true;
                        print(e?.message.toString())
                    }
                })
        }

        override fun onClick(v: View?) {
            val context = itemView.context
            val intent = Intent(context, MovieDetailActivity::class.java)
            context.startActivity(intent)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_item, parent,
                false
            )
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(users[position])

    fun addData(list: List<MovieResults>) {
        users.addAll(list)
    }

    interface CallbackInterface {
        fun passResultCallback(message: MovieResults)
    }

}