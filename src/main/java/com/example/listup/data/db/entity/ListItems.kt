package com.example.listup.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list_items")
data class ListItems(
    @ColumnInfo(name = "item_name")
    var name : String,
    @ColumnInfo(name = "item_amount")
    var amount : Int
) {
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
}