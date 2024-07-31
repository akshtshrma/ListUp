package com.example.listup.other

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listup.R
import com.example.listup.data.db.entity.ListItems
import com.example.listup.databinding.ListItemBinding
import com.example.listup.ui.ListViewModel

class ListItemAdapter(
    var items : List<ListItems>,
    private val viewModel : ListViewModel
) : RecyclerView.Adapter<ListItemAdapter.ListViewHolder>(){


    inner class ListViewHolder(val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentListItem = items[position]

        holder.binding.tvName.text = currentListItem.name
        holder.binding.tvAmount.text = "${currentListItem.amount}"

        holder.binding.ivDelete.setOnClickListener{
            viewModel.delete(currentListItem)
        }

        holder.binding.ivPlus.setOnClickListener{
            currentListItem.amount++
            viewModel.upsert(currentListItem)
        }

        holder.binding.ivMinus.setOnClickListener{
            if(currentListItem.amount>0) {
                currentListItem.amount--
                viewModel.upsert(currentListItem)
            }
        }
    }
}