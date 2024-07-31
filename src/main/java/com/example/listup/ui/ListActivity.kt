package com.example.listup.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listup.R
import com.example.listup.data.db.ListDatabase
import com.example.listup.data.db.entity.ListItems
import com.example.listup.data.repository.ListRepository
import com.example.listup.databinding.ActivityListBinding
import com.example.listup.databinding.DialogAddListItemBinding
import com.example.listup.databinding.ListItemBinding
import com.example.listup.other.ListItemAdapter

class ListActivity : ComponentActivity() {
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot())
        val dataBase = ListDatabase(this)
        val repository = ListRepository(dataBase)
        val factory = ListViewModelFactory(repository)


        val viewModel = ViewModelProvider(this, factory).get(ListViewModel::class.java)

        val adapter = ListItemAdapter(listOf(), viewModel)

        binding.rvShoppingItems.layoutManager = LinearLayoutManager(this)
        binding.rvShoppingItems.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer{
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        binding.fab.setOnClickListener{
            AddListItemDialog( this,
                object : AddDialogListener{
                    override fun onAddButtonClicked(item: ListItems) {
                        viewModel.upsert(item)
                    }
                }).show()
        }

    }
}

