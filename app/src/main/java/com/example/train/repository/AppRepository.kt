package com.example.train.repository

import androidx.lifecycle.MutableLiveData
import com.example.train.entity.RecyclerData
import com.example.train.entity.RecyclerList
import com.example.train.network.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepository
@Inject constructor(val service: NetworkService){
    fun getData(query:String,livedata:MutableLiveData<List<RecyclerData>>){
        val call: Call<RecyclerList> = service.getSearch(query = query)
        call.enqueue(object: Callback<RecyclerList>{
            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                livedata.postValue(response.body()?.items)
            }

            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
               livedata.postValue(null)
            }

        })

    }
}