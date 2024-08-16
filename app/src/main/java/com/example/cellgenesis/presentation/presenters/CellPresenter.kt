package com.example.cellgenesis.presentation.presenters

import android.util.Log
import com.example.cellgenesis.domain.model.Event
import com.example.cellgenesis.domain.usecase.AddCellUseCase
import com.example.cellgenesis.domain.usecase.CheckLifeStatusUseCase
import com.example.cellgenesis.presentation.views.CellView
import io.reactivex.disposables.CompositeDisposable

class CellPresenter(
    private val view: CellView,
    private val addCellUseCase: AddCellUseCase,
    private val checkLifeStatusUseCase: CheckLifeStatusUseCase
) {
    private val disposables = CompositeDisposable()


    fun onAddCellButton(){
        val disposable = addCellUseCase()
            .flatMap { cells ->
                checkLifeStatusUseCase(cells)
                    .map { event -> Pair(cells, event) }
            }
            .subscribe { (cells, event) ->
                if (event is Event.CreateLife) {
                    view.showCells(cells, event)
                }
                else if (event is Event.DestroyLife){
                    view.showCells(cells, event)
                } else{
                    view.showCells(cells, event)
                }
            }
        disposables.add(disposable)
    }

    fun onDestroy(){
        disposables.clear()
    }
}
