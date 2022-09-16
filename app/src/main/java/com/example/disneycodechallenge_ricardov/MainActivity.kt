package com.example.disneycodechallenge_ricardov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.disneycodechallenge_ricardov.adapter.CustomerAdapter
import com.example.disneycodechallenge_ricardov.data.CustomerDto

class MainActivity : AppCompatActivity() {

    private var reservationRecyclerView: RecyclerView? = null
    private var noReservationRecyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        reservationRecyclerView = findViewById(R.id.reservationRecyclerView)
        noReservationRecyclerView = findViewById(R.id.noReservationRecyclerView)

        val resAdapter = CustomerAdapter(reservationList(generateData()))
        val noResAdapter = CustomerAdapter(noReservationList(generateData()))
        val layoutManager = LinearLayoutManager(applicationContext)
        reservationRecyclerView?.layoutManager = layoutManager
        noReservationRecyclerView?.layoutManager = layoutManager

        reservationRecyclerView?.adapter = resAdapter
        noReservationRecyclerView?.adapter = noResAdapter
        resAdapter.notifyDataSetChanged()
        noResAdapter.notifyDataSetChanged()

    }

    private fun generateData(): ArrayList<CustomerDto> {
        val result = ArrayList<CustomerDto>()

        result.add(CustomerDto("Bret Budler", true))
        result.add(CustomerDto("Bud Brettenton", true))
        result.add(CustomerDto("Manny Munster", true))
        result.add(CustomerDto("Tracy Trundle", true))
        result.add(CustomerDto("Grace Prently", true))
        result.add(CustomerDto("Oswald Duke", true))
        result.add(CustomerDto("Hampton Wester", true))
        result.add(CustomerDto("Doug DeMario", true))
        result.add(CustomerDto("Hannah Banana", false))
        result.add(CustomerDto("Josh Nichols", false))
        result.add(CustomerDto("Reggie Adams", false))
        result.add(CustomerDto("David Buster", false))


        return result
    }

    private fun reservationList(list: ArrayList<CustomerDto>): ArrayList<CustomerDto> {
        val result = ArrayList<CustomerDto>()

        for (i in list) {
            if (i.reservation) {
                result.add(i)
            }
        }

        return result
    }

    private fun noReservationList(list: ArrayList<CustomerDto>): ArrayList<CustomerDto> {
        val result = ArrayList<CustomerDto>()

        for (i in list) {
            if (!i.reservation) {
                result.add(i)
            }
        }

        return result
    }
}