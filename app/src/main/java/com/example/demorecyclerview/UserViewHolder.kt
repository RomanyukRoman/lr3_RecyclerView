package com.example.demorecyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.demorecyclerview.databinding.UserBinding

class UserViewHolder(private val binding: UserBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(user: User){

        binding.userImage.setImageResource(user.image)
        binding.userName.text = user.name
        binding.userEmail.text = user.email
    }
}