package com.example.train.entity

data class RecyclerData(val name:String?,val description:String?,val owner:Owner?)
data class RecyclerList(val items:List<RecyclerData>)
data class Owner(val avatar_url:String?)