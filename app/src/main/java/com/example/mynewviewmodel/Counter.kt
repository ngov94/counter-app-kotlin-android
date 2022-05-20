package com.example.mynewviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class Counter : AppCompatActivity() {
    lateinit var counter: TextView
    lateinit var cvm: CounterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        counter = findViewById(R.id.countDown)

        cvm = ViewModelProvider(this)[CounterViewModel::class.java]

        //here you are tuning into the radio station
        cvm.countDown()

        //live data is an observable, so it can be observed
        //this is where I am subscribing
        cvm.getLiveCounter().observe(this,Observer{
            //I will get whatever that is broadcasted
            counter.text = it.toString()
        })

        //can subscribe to as many channels as you want
        cvm.getFinish().observe(this,Observer{
            //I will get whatever that is broadcasted
            if(it)
                counter.text = "BOOM!!!"
        })

    }


}

