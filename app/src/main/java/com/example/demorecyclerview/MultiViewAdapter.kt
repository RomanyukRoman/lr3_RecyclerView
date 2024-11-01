package com.example.demorecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demorecyclerview.databinding.CompanyBinding
import com.example.demorecyclerview.databinding.UserBinding

class MultiViewAdapter(private val list: ArrayList<ItemTypeInterface>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){

            ItemTypeInterface.USER_TYPE -> UserViewHolder(UserBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            ItemTypeInterface.COMPANY_TYPE -> CompanyViewHolder(CompanyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw IllegalArgumentException("Invalid item type")
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return when(list[position].getType()){

            ItemTypeInterface.USER_TYPE -> (holder as UserViewHolder).bind(user = list[position] as User)
            ItemTypeInterface.COMPANY_TYPE -> (holder as CompanyViewHolder).bind(company = list[position] as Company)
            else -> throw IllegalArgumentException("Invalid item type")
        }
    }
    override fun getItemViewType(position: Int): Int {
        return list[position].getType()
    }
}