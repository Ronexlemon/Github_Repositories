package com.example.train

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

import com.example.train.entity.RecyclerData
import com.example.train.viewmodels.MainViewModel

@Composable
fun MainScreen(modifier: Modifier =Modifier,viewmodel:MainViewModel,scaffoldState: ScaffoldState ){
    Scaffold(
        scaffoldState = scaffoldState,
        content = {
            Recycler(viewmodel =viewmodel )
        }
    )


}
@Composable
fun Recycler(viewmodel:MainViewModel){
    val list by viewmodel.livedata.observeAsState(initial = emptyList())
    Column{
        Button(onClick = { viewmodel.loadData() }) {
            Text(text="Click")
        }
    }
    LazyColumn{
        items(items=list,itemContent = {item->
            ItemsCollect(data = item)
        })

    }
}
@Composable
fun ItemsCollect(modifier:Modifier=Modifier,data:RecyclerData){
    Column(modifier.fillMaxSize()){
        Row(modifier.fillMaxWidth()){
            Text(text="${data.name}")
            Text(text="${data.description}")
        }
        Image(painter = rememberAsyncImagePainter(data.owner?.avatar_url), contentDescription =null ,modifier = Modifier.size(128.dp).background(color= Color.Blue))
    }
}