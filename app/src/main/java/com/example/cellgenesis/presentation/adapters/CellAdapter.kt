package com.example.cellgenesis.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cellgenesis.databinding.ItemAliveBinding
import com.example.cellgenesis.databinding.ItemDeadBinding
import com.example.cellgenesis.databinding.ItemLifeBinding
import com.example.cellgenesis.domain.model.Cell
import com.example.cellgenesis.domain.model.Event


class CellAdapter : ListAdapter<Any, RecyclerView.ViewHolder>(CellDiffCallback) {

    companion object {
        private const val TYPE_ALIVE = 0
        private const val TYPE_DEAD = 1
        private const val TYPE_LIFE = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Cell.Alive -> TYPE_ALIVE
            is Cell.Dead -> TYPE_DEAD
            is Event.CreateLife -> TYPE_LIFE
            else -> throw IllegalArgumentException("Unknown type")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_ALIVE -> {
                val binding =
                    ItemAliveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                AliveViewHolder(binding)
            }

            TYPE_DEAD -> {
                val binding =
                    ItemDeadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                DeadViewHolder(binding)
            }

            TYPE_LIFE -> {
                val binding =
                    ItemLifeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                LifeViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Unknown view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is AliveViewHolder -> holder.bind(getItem(position) as Cell.Alive)
            is DeadViewHolder -> holder.bind(getItem(position) as Cell.Dead)
            is LifeViewHolder -> holder.bind(getItem(position) as Event.CreateLife)
        }
    }


    fun removeItem(position: Int) {
        if (position == -1) {
            return
        }
        val currentList = currentList.toMutableList()
        currentList.removeAt(position)
        submitList(currentList)
    }

    fun addLife() {
        val currentList = currentList.toMutableList()
        currentList.add(Event.CreateLife)
        submitList(currentList) {
        }
    }
}
