package com.example.adminwaves_of_food_app.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adminwaves_of_food_app.databinding.OutForDeliveryItemBinding

class OutForDeliveryAdapter(private val CustomerName: ArrayList<String>,private val MoneyStatus: ArrayList<String>) : RecyclerView.Adapter<OutForDeliveryAdapter.OutForDeliveryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OutForDeliveryViewHolder {

        val binding = OutForDeliveryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return OutForDeliveryViewHolder(binding)
    }


    override fun onBindViewHolder(holder: OutForDeliveryViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int = CustomerName.size
    inner class OutForDeliveryViewHolder(private val binding: OutForDeliveryItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
                binding.apply {
                    customerName.text = CustomerName[position]
                    val colorMap = mapOf(
                        "received" to Color.GREEN,"notReceived" to Color.RED,"delivered" to Color.GRAY
                    )
                    paymentStatus.text = MoneyStatus[position]
                    deliveryStatus.setTextColor(colorMap[MoneyStatus[position]]?: Color.BLACK)
                    statusColor.setCardBackgroundColor(colorMap[MoneyStatus[position]]?: Color.BLACK)
                }
        }

    }
}