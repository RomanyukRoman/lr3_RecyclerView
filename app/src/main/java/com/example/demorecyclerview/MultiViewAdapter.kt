package com.example.demorecyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demorecyclerview.databinding.CompanyBinding
import com.example.demorecyclerview.databinding.UserBinding

class MultiViewAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list: ArrayList<ItemTypeInterface> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newList: ArrayList<ItemTypeInterface>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
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

    class UserViewHolder(private val binding: UserBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User){

            binding.userImage.setImageResource(user.image)
            binding.userName.text = user.name
            binding.userEmail.text = user.email
        }
    }

    class CompanyViewHolder(private val binding: CompanyBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(company: Company){
            binding.companyName.text = company.name
            binding.companyNumber.text = company.number
            binding.companyEmail.text = company.email
        }
    }
}