package com.example.cellgenesis.presentation.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.cellgenesis.databinding.ItemAliveBinding
import com.example.cellgenesis.databinding.ItemDeadBinding
import com.example.cellgenesis.domain.model.Cell

class DeadViewHolder(val binding: ItemDeadBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(dead: Cell.Dead) {

    }
}