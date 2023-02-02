package com.example.pdpacademytask6_2_1.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.pdpacademytask6_2_1.model.Food

class DataBaseClass(context: Context) :SQLiteOpenHelper(
    context, DB_NAME, null, DB_VERSION), DataBaseService{

    companion object{
            const val DB_NAME = "food_list"
            const val DB_VERSION = 1

            const val TABLE_NAME = "food"
            const val FOOD_ID = "id"
            const val FOOD_NAME = "food_name"
            const val FOOD_PRODUCT = "food_product"
            const val METHOD_PREPARATION  = "food_preparation"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val query = "create table $TABLE_NAME  ($FOOD_ID integer not null primary key autoincrement, $FOOD_NAME text not null, $FOOD_PRODUCT text not null, $METHOD_PREPARATION text not null )"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    override fun addFood(food: Food) {
        val database = this.writableDatabase

        val contentValues = ContentValues()

        contentValues.put(FOOD_NAME, food.name)
        contentValues.put(FOOD_PRODUCT, food.product)
        contentValues.put(METHOD_PREPARATION, food.preparation)

        database.insert(TABLE_NAME, null, contentValues)
    }

    @SuppressLint("Recycle")
    override fun listFood(): List<Food> {
        var list = ArrayList<Food>()

        val database = this.readableDatabase
        val query = "select * from $TABLE_NAME"
        val cursor = database.rawQuery(query, null)

        if (cursor.moveToFirst()){
            do {
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val product = cursor.getString(2)
                val preparation= cursor.getString(3)
                val contact = Food(id, name, product, preparation)
                list.add(contact)
            }while (cursor.moveToNext())
        }

        return list
    }
}