package com.example.listup.ui

import com.example.listup.data.db.entity.ListItems

interface AddDialogListener {
    fun onAddButtonClicked(item : ListItems)
}