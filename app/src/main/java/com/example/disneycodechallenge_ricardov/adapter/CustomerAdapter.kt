package com.example.disneycodechallenge_ricardov.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.disneycodechallenge_ricardov.R
import com.example.disneycodechallenge_ricardov.data.CustomerDto

class CustomerAdapter(private var items: ArrayList<CustomerDto>): RecyclerView.Adapter<CustomerAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userDto = items[position]
        holder.txtName?.text = userDto.name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.customer_list_item, parent, false)

        return ViewHolder(itemView)
    }

    class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        var txtName: TextView? = null

        init {
            this.txtName = row.findViewById(R.id.customerName)
        }
    }
}