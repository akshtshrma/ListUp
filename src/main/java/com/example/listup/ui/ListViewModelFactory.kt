package com.example.listup.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.listup.data.repository.ListRepository

@Suppress("UNCHECKED_CAST")
class ListViewModelFactory(
    private val repository : ListRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListViewModel(repository) as T
    }
}