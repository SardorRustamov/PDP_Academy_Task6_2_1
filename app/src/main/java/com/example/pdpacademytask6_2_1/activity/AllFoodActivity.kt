package com.example.pdpacademytask6_2_1.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pdpacademytask6_2_1.adapter.FoodAdapter
import com.example.pdpacademytask6_2_1.database.DataBaseClass
import com.example.pdpacademytask6_2_1.databinding.ActivityAllFoodBinding
import com.example.pdpacademytask6_2_1.model.Food

class AllFoodActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAllFoodBinding
    lateinit var dataBaseClass: DataBaseClass
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataBaseClass = DataBaseClass(this)

        val foodList = dataBaseClass.listFood()

        foodAdapter = FoodAdapter(foodList) { position ->

            val intent = Intent(this, InfoFoodActivity::class.java)

            intent.putExtra("name", foodList[position].name)
            intent.putExtra("product", foodList[position].product)
            intent.putExtra("preparation", foodList[position].preparation)

                startActivity(intent)
        }

        binding.rv.adapter=foodAdapter
    }
}