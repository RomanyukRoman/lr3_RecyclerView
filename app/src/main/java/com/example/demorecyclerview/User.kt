package com.example.demorecyclerview

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "user")
data class User(
    @ColumnInfo("id_Image") val image: Int,
    @ColumnInfo("user_name")val name: String,
    @ColumnInfo("user_email")val email: String):
    ItemTypeInterface{
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0
    override fun getType(): Int {
        return ItemTypeInterface.USER_TYPE
    }
}