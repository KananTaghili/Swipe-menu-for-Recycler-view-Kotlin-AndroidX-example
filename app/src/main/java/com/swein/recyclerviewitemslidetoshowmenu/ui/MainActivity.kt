package com.swein.recyclerviewitemslidetoshowmenu.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.swein.recyclerviewitemslidetoshowmenu.adapter.Adapter
import com.swein.recyclerviewitemslidetoshowmenu.databinding.ActivityMainBinding
import com.swein.recyclerviewitemslidetoshowmenu.setItemTouchHelper

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: Adapter
    private var list = ArrayList<String>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        for (i in 0 until 60) {
            list.add(i.toString())
        }

        adapter = Adapter(list)
        recyclerView.adapter = adapter

        setItemTouchHelper(this, recyclerView, adapter)
    }
}