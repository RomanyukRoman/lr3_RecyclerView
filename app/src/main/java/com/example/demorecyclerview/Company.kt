package com.example.demorecyclerview

data class Company(
    val name: String,
    val number: String,
    val email: String): ItemTypeInterface{
    override fun getType(): Int {
        return ItemTypeInterface.COMPANY_TYPE
    }
}