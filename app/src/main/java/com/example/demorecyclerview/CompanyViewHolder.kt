package com.example.demorecyclerview
import androidx.recyclerview.widget.RecyclerView
import com.example.demorecyclerview.databinding.CompanyBinding

class CompanyViewHolder(private val binding: CompanyBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(company: Company){
        binding.companyName.text = company.name
        binding.companyNumber.text = company.number
        binding.companyEmail.text = company.email
    }
}