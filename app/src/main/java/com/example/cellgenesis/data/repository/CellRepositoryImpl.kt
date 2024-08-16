package com.example.cellgenesis.data.repository

import android.util.Log
import com.example.cellgenesis.domain.model.Cell
import com.example.cellgenesis.domain.model.Event
import com.example.cellgenesis.domain.repository.CellRepository
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import kotlin.random.Random

class CellRepositoryImpl : CellRepository {
    private val cells = mutableListOf<Cell>()
    private val cellsSubject = BehaviorSubject.createDefault<List<Cell>>(emptyList())
    private val processedCells = mutableListOf<Cell>()


    override fun addCell(): Observable<List<Cell>> {
        val newCell = if (Random.nextInt(0,2) == 0) Cell.Dead() else Cell.Alive()
        cells.add(newCell)
        cellsSubject.onNext(cells)
        return cellsSubject
    }

    override fun checkLifeStatus(cells: List<Cell>): Observable<Event> {
        processedCells.add(cells.last())
        if (processedCells.size >= 3) {
            val lastThreeCells = cells.takeLast(3)
            var event: Event = Event.Inactive
            event = when {
                lastThreeCells.all { it is Cell.Alive } -> Event.CreateLife
                lastThreeCells.all { it is Cell.Dead } -> Event.DestroyLife
                else -> event
            }
            if ((event == (Event.CreateLife)) || (event == (Event.DestroyLife))) {
                processedCells.clear()
            }

            return Observable.just(event)
        }
        return Observable.just(Event.Inactive)

    }
}