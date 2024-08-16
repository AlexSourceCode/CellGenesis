package com.example.cellgenesis.presentation.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.cellgenesis.databinding.ItemAliveBinding
import com.example.cellgenesis.databinding.ItemLifeBinding
import com.example.cellgenesis.domain.model.Event

class LifeViewHolder(val binding: ItemLifeBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(event: Event.CreateLife) {

    }
}