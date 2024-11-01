package com.example.demorecyclerview

data class User(
    val image: Int,
    val name: String,
    val email: String): ItemTypeInterface{
    override fun getType(): Int {
        return ItemTypeInterface.USER_TYPE
    }
}