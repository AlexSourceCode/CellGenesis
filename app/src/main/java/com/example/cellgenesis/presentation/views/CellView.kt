package com.example.cellgenesis.presentation.views

import com.example.cellgenesis.domain.model.Cell

interface CellView {

    fun showCells(cell: Cell, onComplete: () -> Unit)
    fun showLife()
    fun destroyLife()
    fun scrollListToEnd()
}