package com.example.carbontest.ui.main

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carbontest.data.model.MovieResults
import com.example.carbontest.data.repository.MainRepository
import com.example.carbontest.utils.Resource
import com.example.carbontest.utils.Status
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val repo : MainRepository) : ViewModel() {

    private val users = MutableLiveData<Resource<List<MovieResults>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        users.postValue(Resource.loading(null))
        compositeDisposable.add(
            repo.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ userList ->
                    users.postValue(Resource.success(userList.results))
                }, { throwable ->
                    users.postValue(Resource.error(throwable.message.toString(), null))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getUsers(): LiveData<Resource<List<MovieResults>>> {
        return users
    }


    data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

        companion object {

            fun <T> success(data: T?): Resource<T> {
                return Resource(Status.SUCCESS, data, null)
            }

            fun <T> error(msg: String, data: T?): Resource<T> {
                return Resource(Status.ERROR, data, msg)
            }

            fun <T> loading(data: T?): Resource<T> {
                return Resource(Status.LOADING, data, null)
            }

        }

    }

//    enum class Status {
//        SUCCESS,
//        ERROR,
//        LOADING
//    }


}

