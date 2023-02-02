package com.example.pdpacademytask6_2_1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pdpacademytask6_2_1.databinding.ItemFoodBinding
import com.example.pdpacademytask6_2_1.model.Food

class FoodAdapter(
    private val list: List<Food>,
    val onItemClick: (Int)-> Unit,):RecyclerView.Adapter<FoodAdapter.VH>(){

    class VH(var binding: ItemFoodBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.idFood.text = list[position].name

        holder.binding.idFood.setOnClickListener(View.OnClickListener {
            onItemClick.invoke(position)
        })
    }

    override fun getItemCount(): Int {
        return list.size
    }


}