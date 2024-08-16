package com.example.cellgenesis.presentation.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.cellgenesis.databinding.ItemAliveBinding
import com.example.cellgenesis.domain.model.Cell

class AliveViewHolder(val binding: ItemAliveBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(alive: Cell.Alive) {
    }
}