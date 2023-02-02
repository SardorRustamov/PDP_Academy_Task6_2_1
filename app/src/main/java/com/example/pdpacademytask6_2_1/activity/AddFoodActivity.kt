package com.example.pdpacademytask6_2_1.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.pdpacademytask6_2_1.database.DataBaseClass
import com.example.pdpacademytask6_2_1.databinding.ActivityAddFoodBinding
import com.example.pdpacademytask6_2_1.model.Food

class AddFoodActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddFoodBinding
    lateinit var dataBaseClass: DataBaseClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataBaseClass=DataBaseClass(this)

        binding.addFood.setOnClickListener(View.OnClickListener {

            val name = binding.foodName.text.toString()
            val product = binding.desiredProduct.text.toString()
            val preparation = binding.methodFoodPreparation.text.toString()

            if (name.trim().isNotEmpty() && product.trim().isNotEmpty() && preparation.trim().isNotEmpty()) {
                val food = Food(name = name, product = product, preparation = preparation)

                dataBaseClass.addFood(food)

                Toast.makeText(this, " Muvofaqqiyatli", Toast.LENGTH_SHORT).show()
                finish()
            } else Toast.makeText(this, "Iltimos barcha qatorlarni to'ldiring ", Toast.LENGTH_SHORT).show()
        })
    }
}