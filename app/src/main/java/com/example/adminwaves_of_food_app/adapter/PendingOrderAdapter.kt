package com.example.adminwaves_of_food_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adminwaves_of_food_app.databinding.PendingOrderItemBinding


class PendingOrderAdapter(private val Order:ArrayList<String>,private val Quantity:ArrayList<String>):RecyclerView.Adapter<PendingOrderAdapter.PendingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PendingViewHolder {
        val binding = PendingOrderItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  PendingViewHolder(binding)
    }

    override fun getItemCount(): Int = Order.size

    override fun onBindViewHolder(holder: PendingViewHolder, position: Int) {
        holder.bind(position)
    }
    inner class PendingViewHolder(private val binding: PendingOrderItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int) {
                binding.apply {
                    PendingCustomerName.text = Order[position]
                    PendingQuantity.text = Quantity[position]
                }
        }

    }
}