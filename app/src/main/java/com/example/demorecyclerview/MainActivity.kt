package com.example.demorecyclerview

import android.os.Bundle
import androidx.activity.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demorecyclerview.databinding.ActivityMainBinding
import com.example.demorecyclerview.room.AppViewModel

class MainActivity : ComponentActivity() {

    private  lateinit var binding: ActivityMainBinding
    private val viewModel: AppViewModel by viewModels()
    private val adapter = MultiViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        viewModel.itemList.observe(this) { itemList ->
            itemList?.let {
                adapter.submitList(it)
            }
        }
        if (viewModel.itemList.value.isNullOrEmpty()) {
            viewModel.generateItemList()
        }
        binding.deleteButton.setOnClickListener{
            viewModel.deleteItem()
        }
    }
}