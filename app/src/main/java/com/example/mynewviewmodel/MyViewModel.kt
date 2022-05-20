package com.example.mynewviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    //our logic belongs here
    //e.g. calculations for counter

//    private var count = 0
//
//    fun getCounter():Int {
//        return count
//    }
//
//    fun incrementCounter():Int {
//        return ++count
//    }
//
//    fun decrementCounter():Int {
//        return --count
//    }
//
//    fun randomCounter():Int {
//        count = (1000..9999).random()
//        return count
//    }

    //Observer Pattern --- you have some live data, you observe changes and bind it in the view
    private var count = MutableLiveData<Int>(0)


    fun getCounter():LiveData<Int>{
        return count
    }

    fun incrementCounter(){
        count.value = count.value?.plus(1)
    }

    fun decrementCounter(){
        count.value = count.value?.minus(1)
    }

    fun randomCounter(){
        count.value = (1000..9999).random()
    }




}