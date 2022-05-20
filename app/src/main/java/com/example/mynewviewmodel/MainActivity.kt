package com.example.mynewviewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {
    lateinit var numberText: TextView
    lateinit var incremCount: Button
    lateinit var decremCount: Button
    lateinit var randomCount: Button
    lateinit var counter: Button
    lateinit var vm: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        numberText = findViewById(R.id.number)
        incremCount = findViewById(R.id.increment)
        decremCount = findViewById(R.id.decrement)
        randomCount = findViewById(R.id.random)
        counter = findViewById(R.id.counter)

        counter.setOnClickListener {
            val intentCount = Intent(this, Counter::class.java)
            startActivity(intentCount)
        }

//        randomNumber.setText((1000..9999).random().toString())
//        var num = randomNumber.text.toString().toInt()

        //VIEWMODEL------------------------------------------------
        //provider

//        vm = ViewModelProvider(this).get(MyViewModel::class.java)
//        numberText.setText(vm.getCounter().toString())
//
////        incremCount.setOnClickListener {
////            numberText.setText(vm.incrementCounter().toString())
////        }
//        decremCount.setOnClickListener {
//            numberText.setText(vm.decrementCounter().toString())
//        }
//        randomCount.setOnClickListener {
//            numberText.setText(vm.randomCounter().toString())
//        }

        vm = ViewModelProvider(this).get(MyViewModel::class.java)

        incremCount.setOnClickListener {
            vm.incrementCounter()

        }
        decremCount.setOnClickListener {
            vm.decrementCounter()

        }
        randomCount.setOnClickListener {
            vm.randomCounter()

        }

        vm.getCounter().observe(this) {
            numberText.setText("" + it)
        }



        //adapter

        //observer

    }



}