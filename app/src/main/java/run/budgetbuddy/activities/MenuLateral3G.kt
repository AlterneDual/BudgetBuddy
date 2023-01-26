package com.example.mygestorplantillas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import run.budgetbuddy.databinding.ActivityMenuLateral2Binding


class MenuLateral3G : AppCompatActivity() {
    private lateinit var binding: ActivityMenuLateral2Binding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMenuLateral2Binding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}