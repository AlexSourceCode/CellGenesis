package com.example.cellgenesis.domain.usecase

import com.example.cellgenesis.data.repository.CellRepositoryImpl
import com.example.cellgenesis.domain.model.Cell
import com.example.cellgenesis.domain.model.Event
import io.reactivex.Observable

class CheckLifeStatusUseCase(private val repository: CellRepositoryImpl) {

    operator fun invoke(cells: List<Cell>): Observable<Event> = repository.checkLifeStatus(cells)

}