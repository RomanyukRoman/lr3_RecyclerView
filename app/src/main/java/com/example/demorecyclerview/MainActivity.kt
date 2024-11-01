package com.example.demorecyclerview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demorecyclerview.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.recyclerview.adapter = MultiViewAdapter(getList())
    }
    private fun getList(): ArrayList<ItemTypeInterface> {
        val itemList = ArrayList<ItemTypeInterface>()

        for (i in 1..10) {
            itemList.add(User(R.drawable.user5, "User $i", "user$i@gmail.com"))
            itemList.add(Company("Company $i", "+3806123456$i", "company$i@gmail.com"))
        }
        return itemList
    }
}
