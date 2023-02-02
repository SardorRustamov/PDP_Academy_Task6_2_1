package com.example.pdpacademytask6_2_1.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pdpacademytask6_2_1.R
import com.example.pdpacademytask6_2_1.databinding.ActivityInfoFoodBinding

class InfoFoodActivity : AppCompatActivity() {
    private lateinit var binding : ActivityInfoFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val product = intent.getStringExtra("product")
        val preparation = intent.getStringExtra("preparation")

        binding.foodNameId.text = name
        binding.desiredProductId.text = product
        binding.methodFoodPreparationId.text = preparation
    }
}