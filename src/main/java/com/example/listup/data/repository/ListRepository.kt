package com.example.listup.data.repository

import com.example.listup.data.db.entity.ListItems
import com.example.listup.data.db.ListDatabase

class ListRepository(
    private val db : ListDatabase
) {
    suspend fun upsert(item : ListItems) = db.getListDao().upsert(item)

    suspend fun delete(item : ListItems) = db.getListDao().delete(item)

    fun getAllShoppingItems() = db.getListDao().getListItems()
}