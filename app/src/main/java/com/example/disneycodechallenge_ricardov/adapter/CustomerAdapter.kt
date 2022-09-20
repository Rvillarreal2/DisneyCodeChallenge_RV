package com.example.disneycodechallenge_ricardov.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.disneycodechallenge_ricardov.R
import com.example.disneycodechallenge_ricardov.data.CustomerDto

class CustomerAdapter(private var items: ArrayList<CustomerDto>) :
    RecyclerView.Adapter<CustomerAdapter.ViewHolder>() {

    private var checkResList = arrayListOf<CustomerDto>()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userDto = items[position]
        holder.txtName?.text = userDto.name
        holder.checkBox?.setOnClickListener {
            val isChecked = holder.checkBox!!.isChecked
            for (i in items) {
                if (isChecked && items[position].reservation) {
                    checkResList.add(i)
                }
                if (!isChecked) {
                    checkResList.remove(i)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.customer_list_item, parent, false)

        return ViewHolder(itemView)
    }

    fun getCheckedList(): ArrayList<CustomerDto> {
        return checkResList
    }

    class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        var txtName: TextView? = null
        var checkBox: CheckBox? = null

        init {
            this.txtName = row.findViewById(R.id.customerName)
            this.checkBox = row.findViewById(R.id.checkbox)
        }
    }
}