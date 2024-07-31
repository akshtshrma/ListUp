package com.example.listup.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.listup.data.db.entity.ListItems

@Dao
interface ListDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ListItems)

    @Delete
    suspend fun delete(item: ListItems)

    @Query("SELECT * FROM list_items")
    fun getListItems() : LiveData<List<ListItems>>
}