package com.example.demorecyclerview

interface ItemTypeInterface {
    fun getType() : Int
    companion object{
        const val USER_TYPE = 1
        const val COMPANY_TYPE = 2
    }
}