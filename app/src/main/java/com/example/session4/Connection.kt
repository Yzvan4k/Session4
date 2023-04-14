package com.example.session4

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val retrofit = Retrofit.Builder()
    .baseUrl("http://95.31.130.149:8085/")
    .addConverterFactory(GsonConverterFactory.create()).build()

val api = retrofit.create(API::class.java)