package com.example.cellgenesis.domain.usecase

import com.example.cellgenesis.data.repository.CellRepositoryImpl
import com.example.cellgenesis.domain.model.Cell
import com.example.cellgenesis.domain.repository.CellRepository
import io.reactivex.Observable

class AddCellUseCase(private val repository: CellRepositoryImpl) {

    operator fun invoke():Observable<List<Cell>> = repository.addCell()
}