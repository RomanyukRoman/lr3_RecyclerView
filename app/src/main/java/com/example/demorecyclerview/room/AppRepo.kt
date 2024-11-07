package com.example.demorecyclerview.room

import com.example.demorecyclerview.*

class AppRepo (
    private val appDao: AppDao
) {
    suspend fun addData(item: ItemTypeInterface) {
        when (item.getType()) {
            ItemTypeInterface.USER_TYPE -> appDao.insertAllUsers(item as User)
            ItemTypeInterface.COMPANY_TYPE -> appDao.insertAllCompanies(item as Company)
        }
    }

    suspend fun clearData() {
        appDao.clearUsers()
        appDao.clearCompanies()
    }

    suspend fun updateData(item: ItemTypeInterface) {
        when (item.getType()) {
            ItemTypeInterface.USER_TYPE -> appDao.updateUser(item as User)
            ItemTypeInterface.COMPANY_TYPE -> appDao.updateCompany(item as Company)
        }
    }

    suspend fun deleteItem(item: ItemTypeInterface) {
        when (item.getType()) {
            ItemTypeInterface.USER_TYPE -> appDao.deleteUser(item as User)
            ItemTypeInterface.COMPANY_TYPE -> appDao.deleteCompany(item as Company)
        }
    }
}