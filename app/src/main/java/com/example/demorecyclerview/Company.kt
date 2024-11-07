package com.example.demorecyclerview

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "company")
data class Company(
    @ColumnInfo("company_name")val name: String,
    @ColumnInfo("company_number")val number: String,
    @ColumnInfo("company_email")val email: String):
    ItemTypeInterface{
    @PrimaryKey(autoGenerate = true)
        var id: Int = 0
        override fun getType(): Int {
        return ItemTypeInterface.COMPANY_TYPE
    }
}