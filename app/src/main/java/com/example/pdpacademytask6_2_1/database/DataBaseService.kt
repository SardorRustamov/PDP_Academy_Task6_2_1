package com.example.pdpacademytask6_2_1.database

import com.example.pdpacademytask6_2_1.model.Food

interface DataBaseService {

    fun addFood(food: Food)

    fun listFood(): List<Food>

}