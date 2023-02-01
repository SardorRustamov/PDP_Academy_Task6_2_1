package com.example.pdpacademytask6_2_1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pdpacademytask6_2_1.databinding.ItemContactBinding
import com.example.pdpacademytask6_2_1.model.Contact

class ContactAdapter(private val list: List<Contact>):RecyclerView.Adapter<ContactAdapter.VH>(){

    class VH(itemBinding: ItemContactBinding):RecyclerView.ViewHolder(itemBinding.root){
        var binding= itemBinding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.contactName.text = list[position].name
        holder.binding.contactNumber.text = list[position].number
        holder.binding.idNumber.text = list[position].id.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }


}