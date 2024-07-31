package com.example.listup.ui

import androidx.lifecycle.ViewModel
import com.example.listup.data.db.entity.ListItems
import com.example.listup.data.repository.ListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(
    private val repository: ListRepository
) : ViewModel() {

    fun upsert(item : ListItems) = CoroutineScope(Dispatchers.Main).launch{
        repository.upsert(item)
    }

    fun delete(item : ListItems) = CoroutineScope(Dispatchers.Main).launch{
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()
}