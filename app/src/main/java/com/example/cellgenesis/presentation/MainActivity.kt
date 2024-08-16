package com.example.cellgenesis.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cellgenesis.data.repository.CellRepositoryImpl
import com.example.cellgenesis.databinding.ActivityMainBinding
import com.example.cellgenesis.domain.model.Cell
import com.example.cellgenesis.domain.model.Event
import com.example.cellgenesis.domain.usecase.AddCellUseCase
import com.example.cellgenesis.domain.usecase.CheckLifeStatusUseCase
import com.example.cellgenesis.presentation.adapters.CellAdapter
import com.example.cellgenesis.presentation.presenters.CellPresenter
import com.example.cellgenesis.presentation.views.CellView

class MainActivity : AppCompatActivity(), CellView {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var presenter: CellPresenter
    private val adapter by lazy {
        CellAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val repository = CellRepositoryImpl()
        val addCellUseCase = AddCellUseCase(repository)
        val checkLifeStatusUseCase = CheckLifeStatusUseCase(repository)
        presenter = CellPresenter(this, addCellUseCase, checkLifeStatusUseCase)
        setupRecyclerView()
        setupListener()

    }

    private fun setupRecyclerView() {
        binding.rcGenesis.adapter = adapter
        binding.rcGenesis.layoutManager = LinearLayoutManager(this)


    }

    private fun setupListener() {
        binding.btCreate.setOnClickListener {
            presenter.onDestroy()
            presenter.onAddCellButton()
        }
    }

    override fun showCells(cells: List<Cell>, event: Event) { // нарушение паттерна mvp
        val newList = adapter.currentList.toMutableList()
        newList.add(cells.last())
        adapter.submitList(newList){  
            if (event is Event.CreateLife){
                showLife()
            } else if (event is Event.DestroyLife){
                destroyLife()
            }
            binding.rcGenesis.scrollToPosition(newList.size - 1)
        }

    }

    override fun showLife() {
        adapter.addLife()
    }

    override fun destroyLife() {
        val position = adapter.currentList.lastIndexOf(Event.CreateLife)
        if (position == -1){
            return
        }
        adapter.removeItem(position)
    }


}
