package com.example.train.network

import com.example.train.entity.RecyclerData
import com.example.train.entity.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
    @GET("repositories")
    fun getSearch(@Query("q")query:String): Call<RecyclerList>
}