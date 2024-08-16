package com.example.cellgenesis.presentation.adapters

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.cellgenesis.domain.model.Cell
import com.example.cellgenesis.domain.model.Event

object CellDiffCallback : DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return when {
            oldItem is Event.CreateLife && newItem is Event.CreateLife -> true
            oldItem is Cell.Alive && newItem is Cell.Alive -> true
            oldItem is Cell.Dead && newItem is Cell.Dead -> true
            else -> false
        }
    }
}