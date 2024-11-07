package com.example.demorecyclerview.room

import android.app.Application
import androidx.lifecycle.*
import com.example.demorecyclerview.*
import kotlinx.coroutines.launch

class AppViewModel(app: Application) : AndroidViewModel(app) {

    private val repo = (app as App).appRepo

    private val _itemList = MutableLiveData<ArrayList<ItemTypeInterface>>()
    val itemList: LiveData<ArrayList<ItemTypeInterface>> get() = _itemList

    private fun addItem(item: ItemTypeInterface) {
        viewModelScope.launch {
            repo.addData(item)
        }
    }

    fun updateItem(item: ItemTypeInterface) {
        viewModelScope.launch {
            repo.updateData(item)
        }
    }

    fun deleteItem() {
        viewModelScope.launch {

            val currentList = _itemList.value ?: return@launch

            repo.deleteItem(currentList.last())
            _itemList.value = currentList.apply { removeLast() }
        }
    }

    private fun clearAllItems() {
        viewModelScope.launch {
            repo.clearData()
        }
    }

    fun generateItemList() {

        val itemList = ArrayList<ItemTypeInterface>()
        clearAllItems()

        for (i in 1..10) {
            itemList.add(User(R.drawable.user5, "User $i", "user$i@gmail.com"))
            itemList.add(Company("Company $i", "+3806123456$i", "company$i@gmail.com"))

        }
        itemList.forEach{
            addItem(it)
        }
        _itemList.value = itemList
    }
}
