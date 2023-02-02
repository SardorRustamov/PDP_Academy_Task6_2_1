package com.example.pdpacademytask6_2_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pdpacademytask6_2_1.activity.AddFoodActivity
import com.example.pdpacademytask6_2_1.activity.AllFoodActivity
import com.example.pdpacademytask6_2_1.database.DataBaseClass
import com.example.pdpacademytask6_2_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    lateinit var dataB: DataBaseClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataB = DataBaseClass(this)

        binding.addFood.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AddFoodActivity::class.java)
            startActivity(intent)
        })

        binding.foodList.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AllFoodActivity::class.java)
            startActivity(intent)
        })
    }
}