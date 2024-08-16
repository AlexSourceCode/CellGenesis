package com.example.cellgenesis.presentation.views

import com.example.cellgenesis.domain.model.Cell
import com.example.cellgenesis.domain.model.Event

interface CellView {

    fun showCells(cells: List<Cell>, event: Event)
    fun showLife()
    fun destroyLife()

}