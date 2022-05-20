package com.example.mynewviewmodel

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    //1: create variables for live data. The live data is an observable
    private var counter = MutableLiveData<Int>()
    private var finish = MutableLiveData<Boolean>()
    private var started = false

    //2: getter return live data
    fun getLiveCounter(): LiveData<Int>{
        return counter
    }

    fun getFinish(): LiveData<Boolean>{
        return finish
    }

    //radio station
    fun countDown(){
        if(!started) {//to do something only once
            started = true
            object : CountDownTimer(10000, 1000) {

                override fun onTick(millisUntilFinished: Long) {
                    val time = millisUntilFinished / 1000
                    //this is what I am broadcasting (mutable live data)
                    counter.value = time.toInt()
                }

                override fun onFinish() {
                    finish.value = true
                }
            }.start()
        }
    }
}