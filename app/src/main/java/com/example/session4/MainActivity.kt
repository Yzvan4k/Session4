package com.example.session4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.session4.databinding.ActivityMainBinding

lateinit var binding :ActivityMainBinding
lateinit var adapterPlan :AdapterPlan

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        adapterPlan = AdapterPlan(listOf())

        binding.recPlan.apply {
            adapter = adapterPlan
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
        }
    }
}