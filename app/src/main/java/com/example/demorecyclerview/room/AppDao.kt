package com.example.demorecyclerview.room

import androidx.room.*
import com.example.demorecyclerview.Company
import com.example.demorecyclerview.User

@Dao
interface AppDao {
    @Insert
    suspend fun insertAllUsers(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user")
    suspend fun clearUsers()

    /*@Query("DELETE FROM sqlite_sequence WHERE name='user'")
    suspend fun resetUserAutoIncrement()*/

    @Insert
    suspend fun insertAllCompanies(company: Company)

    @Update
    suspend fun updateCompany(company: Company)

    @Delete
    suspend fun deleteCompany(company: Company)

    @Query("DELETE FROM company")
    suspend fun clearCompanies()

}