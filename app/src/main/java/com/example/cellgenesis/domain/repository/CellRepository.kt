package com.example.cellgenesis.domain.repository

import com.example.cellgenesis.domain.model.Cell
import com.example.cellgenesis.domain.model.Event
import io.reactivex.Observable

interface CellRepository {

    fun addCell(): Observable<List<Cell>>
    fun checkLifeStatus(cells: List<Cell>): Observable<Event>
}