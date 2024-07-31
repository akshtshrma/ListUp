@file:Suppress("UNREACHABLE_CODE")

package com.example.listup.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.databinding.ViewDataBinding
import com.example.listup.R
import com.example.listup.data.db.entity.ListItems
import com.example.listup.databinding.DialogAddListItemBinding


class AddListItemDialog(context : Context, var addDialogListener : AddDialogListener) :
    AppCompatDialog(context)
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_list_item)
        val binding = DialogAddListItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot())

        binding.tvAdd.setOnClickListener{
            val name = binding.etName.text.toString()
            val amount = binding.etAmount.text.toString()

            if(name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context,"Please enter all the information", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

                val item = ListItems(name, amount.toInt())
                addDialogListener.onAddButtonClicked(item)
                dismiss()
            }
        }

        binding.tvCancel.setOnClickListener{
            cancel()
        }
    }
}