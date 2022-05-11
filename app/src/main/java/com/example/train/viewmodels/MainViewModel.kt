package com.example.train.viewmodels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.train.entity.RecyclerData
import com.example.train.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel
 @Inject constructor(private val repo:AppRepository,
 //@Assisted private val savedStateHandle: SavedStateHandle
 )   : ViewModel() {
     val livedata:MutableLiveData<List<RecyclerData>>
     init{
         livedata = MutableLiveData()
     }
    fun loadData(){
        repo.getData("john",livedata)
    }
}