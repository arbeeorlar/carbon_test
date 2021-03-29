package com.example.carbontest.data.api

class ApiHelper(private val apiService : ApiService) {

    fun getUsers() = apiService.getUsers()
}